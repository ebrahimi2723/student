package com.ebrahimi2723.io;

import java.util.Scanner;

public  class Io {
    public static String input(){
       Scanner scanner = new Scanner(System.in);
      return scanner.next();
    }
    public static void print(String value){
        System.out.println(value);
    }
}
