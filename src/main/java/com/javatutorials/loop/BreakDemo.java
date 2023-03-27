package com.javatutorials.loop;

public class BreakDemo {

    public static void main(String[] args) {
        int i = 0;


        for(i= 0; i<10; i++)
        {
            if(i==5)
                break;

            System.out.println(i);
        }


    }

}
