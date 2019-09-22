package org.opentutorials.javatutorials.method;

public class ReturnDemo4 {

    public static String[] getMembers() {
        String[] members = { "최진혁", "최유빈", "한이람" };
        return members;
    }

    public static void main(String[] args) {
        String[] members = getMembers();
        System.out.println(members[1]);//최유빈
        System.out.println(members);//주소값?나옴([Ljava.lang.String;@71be98f5)

    }
}
