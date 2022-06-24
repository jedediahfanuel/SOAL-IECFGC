# User input
s = gets.not_nil!
s = s.to_i

i = 0
sum : Int32
while i < s
  i += 1

  n = gets.not_nil!
  n = n.to_i
  sum = (((((((((( (n * 1021) - 98 ) / 17 ).to_i + 7582 ) * 209 ) / 37 ).to_i * 11 ) + 9876 ) - 1 ) * 2 ) - 9876 )
  sum = ( sum / 10 ).to_i.abs % 10

  puts sum
end
