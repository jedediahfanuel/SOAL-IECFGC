use std::{io::{stdout, stdin, Write}};

fn main() {
    let mut input: String = String::new();
    let mut iterate: String = String::new();
    read(&mut iterate);
    
    let iterate: &str = iterate.as_str().trim();
    let iterate: i32 = iterate.to_owned().parse::<i32>().expect("Please input a number for iterator");

    for _ in 0..iterate {
        read(&mut input);

        let input: &str = input.as_str().trim();
        let number: i32 = input.to_owned().parse::<i32>().expect("Please input a number");

        let result = ((((((((((number * 1021) - 98) / 17) + 7582) *209) /37) *11) +9876) -1) *2) -9876;

        println!("{}", get_puluhan(&result));
    }
}

pub fn read(input: &mut String) {
    input.clear();
    stdout().flush().expect("Failed to flush");
    stdin().read_line(input).expect("Failed to read input");
}

pub fn get_puluhan(num: &i32) -> i32 {
    let sum: i32 = ( num / 10 ) % 10;
    sum.abs()
}