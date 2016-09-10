def gets
  DATA.readline
end

t1, t2, n = gets.split(' ').map(&:to_i)

memo = {
  1 => t1,
  2 => t2
}
t = lambda do |n|
  if !memo.key?(n)
    memo[n] = t.(n - 2) + t.(n - 1) ** 2
  end
  memo[n]
end

puts t.(n)

# => 5
__END__
0 1 5
