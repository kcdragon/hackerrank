x1 = 0
v1 = 3
x2 = 4
v2 = 2

n = 1

one = x1 + (v1 * n)
two = x2 + (v2 * n)

previous_diff = 999999999999999999999
diff = [one, two].max - [one, two].min

while one != two && previous_diff > diff
  n += 1

  one = x1 + (v1 * n)
  two = x2 + (v2 * n)

  #puts "one: #{one}"
  #puts "two: #{two}"

  previous_diff = diff
  diff = [one, two].max - [one, two].min

  #puts "previous_diff #{previous_diff}"
  #puts "diff #{diff}"
end

puts one == two ? 'YES' : 'NO'
