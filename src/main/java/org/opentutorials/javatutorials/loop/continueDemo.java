package org.opentutorials.javatutorials.loop;

public class continueDemo {

    public static void main(String[] args) {
        int i = 0;

        
        for(i= 0; i<10; i++)
        {
            if(i==5)
                continue;

            System.out.println(i);//5를 건너뜀
        }


    }

}
