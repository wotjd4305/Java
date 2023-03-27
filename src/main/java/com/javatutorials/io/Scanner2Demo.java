package com.javatutorials.io;

//Scanner라는 녀석을 읽어온다.
import java.util.Scanner;

public class Scanner2Demo {

    //계속 상호작용 가능하게 만들것임.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //hasNextInt는 일단 정지. 대기상태 유지함
        //만약 정수가아니면 falst를 리턴하여 끝냄
        while(sc.hasNextInt()) {
            System.out.println(sc.nextInt()*1000);
        }
        sc.close();
    }
}
