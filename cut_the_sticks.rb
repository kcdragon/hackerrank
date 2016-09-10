def gets
  DATA.readline
end

n = gets.strip.to_i
arr = gets.strip
arr = arr.split(' ').map(&:to_i)
while arr.size > 0
  count = arr.size
  min = arr.min
  arr = arr.map { |e| e - min }.select { |e| e > 0 }
  puts count
end

__END__
6
5 4 4 2 2 8
