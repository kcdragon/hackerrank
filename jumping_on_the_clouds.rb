def gets
  DATA.readline
end

n = gets.strip.to_i
c = gets.strip
c = c.split(' ').map(&:to_i)

i = 0
n = 0
while i < (c.size - 1)
  if (i + 2) < c.size && c[i + 2] == 0
    i += 2
  else
    # (i + 1) < c.size && c[i + 1] == 0
    i += 1
  end

  n += 1
end

puts n

__END__
7
0 0 1 0 0 1 0
