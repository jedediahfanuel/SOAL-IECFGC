# Input jumlah query
q = gets.not_nil!.to_i

q.times do |i|
  # Input ukuran array & posisi array
  n, m, x, y = gets.not_nil!.split.map &.to_i

  x, y = x-1, y-1

  arr = Array.new(n){Array.new(m){0}}

  xTemp, yTemp, color, xMove, yMove = 0, 0, 1, 1, 1
  b, pertama = true, true

  while b
    arr[xTemp][yTemp] = color

    if !pertama
      if xTemp == 0 && yTemp == 0 \
        || xTemp == n-1 && yTemp == 0 \
        || xTemp == 0 && yTemp == m-1 \
        || xTemp == n-1 && yTemp == m-1
        b = false
      end
    end

    pertama = false

    xTemp += xMove
    yTemp += yMove

    if xTemp == n || xTemp < 0
      xMove *= -1
      if color == 9
        color = 1
      else
        color += 1
      end
      xTemp += xMove
    end

    if yTemp == m || yTemp < 0
      yMove *= -1
      if color == 9
        color = 1
      else
        color += 1
      end
      yTemp += yMove
    end
  end
  
  puts(arr[x][y].to_s)
end
