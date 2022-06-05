use std::{io::{stdout, stdin, Write}};

fn main() {
    let mut step_x: u32 = 0;
    let mut step_y: u32 = 0;
    
    let mut n: String = String::new();
    read(&mut n);
    let n: u32 = n.trim().parse::<u32>().expect("Please input a number");

    for _ in 0..n {
        // Panjang lintasan
        let mut d: String = String::new();
        read(&mut d);
        let d: u32 = d.trim().parse::<u32>().expect("Please input a number");

        // Fav subject 1
        let mut x: String = String::new();
        read(&mut x);
        let x: u32 = x.trim().parse::<u32>().expect("Please input a number");

        // Fav subject 2
        let mut y: String = String::new();
        read(&mut y);
        let y: u32 = y.trim().parse::<u32>().expect("Please input a number");

        // Check kalau nomor favorite berbeda
        // Baru lanjut
        if x != y {
            // Hitung habis dibagi berapa dalam deret
            // Untuk sekarang hitung maksimal untuk masing-masing
            step_x = d / x;
            step_y = d / y;

            // Kalau y MOD x, artinya y > x
            // Jadi pasti hanya s1 yang dapat maju
            if (y % x) == 0 {
                step_x -= step_y;
                step_y = 0;
            }
            // Kalau x MOD y, artinya x > y
            // Jadi pasti hanya s2 yang dapat maju
            else if (x % y) == 0 {
                step_y -= step_x;
                step_x = 0;
            }
            // Selain itu
            // Kelipatan perkalian keduanya
            // Bakal dijadiin pengurangan
            else {
                // Kelipatan yang sama
                let z: u32 = d / (x * y);

                // Jumlah dikurangi tabrakan
                step_x -= z;
                step_y -= z;
            }
        }
        // Kalau s1 == s2
        // langsung return default value n1 = 0 ; n2 = 0

        println!("{} {}", step_x, step_y);
        
    }
    
}

pub fn read(input: &mut String) {
    input.clear();
    stdout().flush().expect("Failed to flush");
    stdin().read_line(input).expect("Failed to read input");
}
