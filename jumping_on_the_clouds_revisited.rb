def gets
  DATA.readline
end

n,k = gets.strip.split(' ')
n = n.to_i
k = k.to_i
c = gets.strip
c = c.split(' ').map(&:to_i)

e = 100
i = 0
first_loop = true

while first_loop || i != 0
  i = (i + k) % n

  e -= 1
  if c[i] == 1
    e -= 2
  end
  first_loop = false
end

puts e

__END__
8 2
0 0 1 0 0 1 1 0
