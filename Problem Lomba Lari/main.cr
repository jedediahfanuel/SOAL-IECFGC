# User input
q = gets.not_nil!.to_i
step_x = step_y2 = 0

i = 0
while i < q
  # Panjang lintasan
  d = gets.not_nil!.to_i

  # Fav number subject 1
  x = gets.not_nil!.to_i

  # Fav number subject 2
  y = gets.not_nil!.to_i

  # Check kalau fav number berbeda
  # Baru lanjut
  if x != y
    # Hitung habis dibagi berapa dalam deret
    # Untuk sekarang hitung maksimal untuk masing-masing
    step_x = d // x
    step_y = d // y

    # Kalau y MOD x, artinya y > x
    # Jadi pasti hanya s1 yang dapat maju
    if y & x == 0
      step_x -= step_y
      step_y = 0
    
    # Kalau x MOD y, artinya x > y
    # Jadi pasti hanya s2 yang dapat maju
    elsif x % y == 0
      step_y -= step_x
      step_x = 0

    # Selain itu
    # Kelipatan perkalian keduanya
    # Bakal dijadiin pengurangan
    else
      # Kelipatan yang sama
      z = d // (x * y)

      # Jumlah dikurangi tabrakan
      step_x -= z
      step_y -= z
    end
  end
  # kalau x == y
  # langsung return default value
  # n1 = 0 , n2 = 0

  puts
  puts "#{step_x} #{step_y}"
  i += 1
end
