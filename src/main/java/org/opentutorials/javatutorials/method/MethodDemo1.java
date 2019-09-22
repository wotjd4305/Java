package org.opentutorials.javatutorials.method;

public class MethodDemo1 {

    public static void numbering()
    {
        int i = 0;
        while(i<10)
        {
            System.out.println(i);
            i++;
        }
    }

    //너무 똑같으면 재활용성이 낮아짐 -> 입력과 출력으로 유연하게
    public static void main(String[] args)
    {
      numbering();
    }

}
