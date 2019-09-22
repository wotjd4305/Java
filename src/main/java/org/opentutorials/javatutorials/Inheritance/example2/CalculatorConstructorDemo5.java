package org.opentutorials.javatutorials.Inheritance.example3;

class Calculator {
    int left, right;

    public Calculator(int left, int right){
        this.left = left;
        this.right = right;
    }

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

class SubstractionableCalculator extends Calculator {
    public SubstractionableCalculator(int left, int right) {

        //초기화 코드는 super다음에 호출되어야함! 아니면 (!)오류
        super(left,right);

        //다음 코드는 중복이 되서 오류
       /* this.left = left;
        this.right = right;
        */
    }

    public void substract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorConstructorDemo5 {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}