use std::{io::{stdout, stdin, Write}};

fn main() {
    let mut mahasiswa: String = String::new();
    let mut dosen: String = String::new();
    
    read(&mut mahasiswa);
    read(&mut dosen);

    let mahasiswa: u32 = mahasiswa.trim().parse::<u32>().expect("Please input a number");
    let dosen: u32 = dosen.trim().parse::<u32>().expect("Please input a number");
    
    let mut vec_urutan: Vec<u32> = Vec::new();
    let mut vec_interaksi: Vec<u32> = Vec::new();

    // Input untuk urutan mahasiswa mula-mula
    for _ in 0..mahasiswa {
        let mut n: String = String::new();
        read(&mut n);
        let n: u32 = n.trim().parse::<u32>().expect("Please input a number");
        vec_urutan.push(n);
    }

    // Input untuk urutan mahasiswa yang berinteraksi dengan dosen
    for _ in 0..dosen {
        let mut n: String = String::new();
        read(&mut n);
        let n: u32 = n.trim().parse::<u32>().expect("Please input a number");
        vec_interaksi.push(n);
    }

    println!("{}", proses(&mut vec_urutan, vec_interaksi));
    
}

pub fn read(input: &mut String) {
    input.clear();
    stdout().flush().expect("Failed to flush");
    stdin().read_line(input).expect("Failed to read input");
}

pub fn proses(vec_mhs: &mut Vec<u32>, vec_dsn: Vec<u32>) -> u32 {
    let mut tick: u32 = 0;
    
    for i in vec_dsn {

        for j in 0..vec_mhs.len() {
            
            if vec_mhs[j] == i {
                // Tambah tick
                tick += 2 * (j as u32);

                // Geser ranking keaktifan
                for k in (1..=j).rev() {
                    vec_mhs[k] = vec_mhs[k - 1];
                }
                
                // Mindahin mahasiswa terbaru yang aktif
                vec_mhs[0] = i;
            }

        }

    }
    
    tick
}
