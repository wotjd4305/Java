package com.javatutorials.overloading;
class Calculator{
    int left, right;
    int third = 0;

    public void setOprands(int left, int right){
        System.out.println("setOprands(int left, int right)");
        this.left = left;
        this.right = right;
    }

    //위 코드랑 중복이 발생.. 주석처리 후,
    //
    public void setOprands(int left, int right, int third){
        /*System.out.println("setOprands(int left, int right, int third)");
        this.left = left;
        this.right = right;*/

        //위의 메소드를 미리 호출 후, 다음작업코드 제시시
       this.setOprands(left, right);
        System.out.println("setOprands(int left, int right, int third)");
        this.third = third;
    }

    public void sum(){
        System.out.println(this.left+this.right+this.third);
    }

    public void avg(){
        System.out.println((this.left+this.right+this.third)/3);
    }
}

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.setOprands(10, 20, 30);
        c1.sum();
        c1.avg();

    }

}