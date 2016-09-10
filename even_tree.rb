def gets
  DATA.readline
end

n, m = gets.split(' ').map(&:to_i)

graph = Array.new(n + 1) { Array.new(n + 1) }

m.times do
  v1, v2 = gets.split(' ').map(&:to_i)
  graph[v1][v2] = true
  graph[v2][v1] = true
end

def copy(graph)
  graph.map { |r| r.dup }
end

def children(graph, v)
  graph[v].map.with_index { |val, i| val ? i : nil }.compact
end

def remove(graph, v1, v2)
  graph = copy(graph)
  graph[v1][v2] = nil
  graph[v2][v1] = nil
  graph
end

def connected_vertices(graph, v, visited = [])
  children = children(graph, v) - visited
  children + children.flat_map { |c| connected_vertices(graph, c, [v] + children) }
end

def connected_components(graph)
  n = (graph.count - 1)

  connected_components = []

  unseen_vertices = (1..n).to_a
  while unseen_vertices.count > 0
    v = unseen_vertices.first
    connected_component = ([v] + connected_vertices(graph, v)).sort
    unseen_vertices -= connected_component
    connected_components << connected_component
  end

  return connected_components
end

def edges(graph)
  n = (graph.count - 1)
  (1..n).flat_map { |v| children(graph, v).map { |c| [v, c].sort } }.uniq
end

def valid_edges_to_remove(graph)
  edges = edges(graph)
  edges.select do |edge|
    connected_components(remove(graph, *edge)).all? do |cc|
      cc.count.even?
    end
  end
end

def print_edges(edges)
  edges.map { |a| a.join(',') }
end

def max_number_of_removed_edges(graph)
  edge = valid_edges_to_remove(graph)[0]
  if edge
    max_number_of_removed_edges(remove(graph, *edge)) + 1
  else
    0
  end
end

max = nil
require 'ruby-prof'
result = RubyProf.profile do
  max = max_number_of_removed_edges(graph)
end
printer = RubyProf::FlatPrinter.new(result)
printer.print(STDOUT, {})

puts max

# __END__
# 10 9
# 2 1
# 3 1
# 4 3
# 5 2
# 6 1
# 7 2
# 8 6
# 9 8
# 10 8

__END__
30 29
2 1
3 2
4 3
5 2
6 4
7 4
8 1
9 5
10 4
11 4
12 8
13 2
14 2
15 8
16 10
17 1
18 17
19 18
20 4
21 15
22 20
23 2
24 12
25 21
26 17
27 5
28 27
29 4
30 25
