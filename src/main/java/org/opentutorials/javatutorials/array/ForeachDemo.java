package org.opentutorials.javatutorials.array;

public class ForeachDemo {

    public static void main(String[] args)
    {
        //e라는 값에 members의 녀석들을 넣어주자.
        //이 문법은 반복문과 배열의 밀접한 관계에 의해 만들어짐.
        //자바스크립트. 파이썬. PHP같은 언어는 배열의 크기를 정해주지않음
        //자바는 컬렉션(컨테이너)이라는 기능을 사용
        String[] members = { "최진혁", "최유빈", "한이람" };
        for (String e : members) {
            System.out.println(e + "이 상담을 받았습니다");
        }
    }

}
