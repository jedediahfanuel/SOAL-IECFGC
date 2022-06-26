module Keaktifan
  mahasiswa  = gets.not_nil!.to_u32
  dosen = gets.not_nil!.to_u32

  arr_urutan = [] of UInt32
  arr_interaksi = [] of UInt32

  # Input untuk urutan mahasiswa mula-mula
  n : UInt32
  mahasiswa.times do
    n = gets.not_nil!.to_u32
    arr_urutan << n
  end

  # Input untuk urutan mahasiswa yang berinteraksi dengan dosen
  dosen.times do
    n = gets.not_nil!.to_u32
    arr_interaksi << n
  end

  puts
  puts proses(arr_urutan, arr_interaksi)
end

def proses(arr_mhs, arr_dsn)
  tick : UInt32 = 0

  arr_dsn.each do |who_interact|
    j : UInt32 = 0
    while j < arr_mhs.size
      if arr_mhs[j] == who_interact
          # Tambah tick
          tick += 2 * j
          # Geser ranking keaktifan
          (1..j).reverse_each do |k|
            arr_mhs[k] = arr_mhs[k - 1]
          end
          
          # Mindahin mahasiswa terbaru yang aktif
          arr_mhs[0] = who_interact
      end
      j += 1
    end
  end

  tick
end
