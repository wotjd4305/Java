package com.javatutorials.progenitor;

class Student implements Cloneable{
    String name;
    Student(String name){
        this.name = name;
    }

    public Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}

class ObjectDemo {

    public static void main(String[] args) {
        Student s1 = new Student("egoing");
        Student s2 = (Student) s1.clone();

        System.out.println(s1.name);
        System.out.println(s2.name);



    }

}