package org.opentutorials.javatutorials.datatype;

public class IntDatatypeDemo {

    public static void main(String[] args)
    {
        //범위-128~127
        //다음은 a에 담을수 없기때문에 미스매치 short나 int,long써야함.
        //byte=1, short=2, int=4,long=8
        //문자인 char=2
        byte a;
        //a=128;

        //숫자의 크기에 따라 용량을차지하는게아니고 타입에따라서
        //->둘은 똑같음.
        long b = 214783647;
        long c = 1;

    }

}
