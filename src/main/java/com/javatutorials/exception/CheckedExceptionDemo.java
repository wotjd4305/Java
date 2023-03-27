package com.javatutorials.exception;
import java.io.*;
public class CheckedExceptionDemo {
    public static void main(String[] args) {
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //초기화 실패해서 없는 녀석을 쓸수도 있기때문에
        String input = null;
        try {
            input = bReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input);
    }
}