package org.opentutorials.javatutorials.Object;

//this는 클래스를 통해서 만들어진 인스턴스 자신을 뜻함.
class Calculator{
    int left, right;

    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }

    public void sum(){
        System.out.println(this.left+this.right);
    }

    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
}

class CalculatorDemo4{

    public static void main(String[] args) {

        //c1, c2는 인스턴스
        //데이터 타입을 직접 만드는 느낌! Calculator라는 데이터타입
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();

        Calculator c2 = new Calculator();
        c2.setOprands(20, 40);
        c2.sum();
        c2.avg();
    }

}