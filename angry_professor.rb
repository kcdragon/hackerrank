def gets
  DATA.readline
end

tests = gets.to_i
tests.times do
  n, k = gets.split(" ").map(&:to_i)
  a = gets.split(" ").map(&:to_i)
  students_in_class_on_time = a.reject { |e| e > 0 }.count
  puts students_in_class_on_time < k ? 'YES' : 'NO'
end

__END__
2
4 3
-1 -3 4 2
4 2
0 -1 2 1
