package com.javatutorials.io;

public class InputForeachDemo {

    //인자로 one two three주면 결과도 one \n two \n three
    public static void main(String[] args)
    {
        for(String e : args)
        {
            System.out.println(e);
        }
    }
}
