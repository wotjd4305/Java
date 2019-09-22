package org.opentutorials.javatutorials.io;

import java.util.Scanner;
import java.io.*;

public class Scanner3Demo {

    public static void main(String[] args) {
        try {
            //System.in은 사용자가 입력한 값
            //file은 파일의 값을 얻어와라
            //파일값이 1234\n5451이면 1234000\n5451000이됨.
            File file = new File("out.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextInt()) {
                System.out.println(sc.nextInt()*1000);
            }
            sc.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

}