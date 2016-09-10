# n, k = gets.split(" ").map(&:to_i)
# a = gets.split(" ").map(&:to_i)

n, k = 6, 3
a = [1, 3, 2, 6, 1, 2]

count = a.flat_map.with_index do |ai, i|
  a.select.with_index do |aj, j|
    i < j && ((ai + aj) % k == 0)
  end
end.count

puts count
