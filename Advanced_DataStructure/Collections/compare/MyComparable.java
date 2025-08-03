// package Collections.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// if we want to compare two students we need a comparator but we want our custom logic so
// there are two way like use comparator object or implement comparable interface

class Student implements Comparable<Student> {

    String name;
    int age;
    float marks;

    Student(String name, int age, float marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int compareTo(Student other) {
        return this.age > other.age ? 1 : -1;
    }

    @Override
    public String toString() {
        return (
            '[' +
            this.name +
            ", age = " +
            this.age +
            ", marks = " +
            this.marks +
            ']'
        );
    }
}

class MyComparable {

    public static void main(String[] a) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("deep", 23, 75.5f));
        studentList.add(new Student("bud", 22, 85f));
        studentList.add(new Student("dipan", 21, 69.46f));
        Collections.sort(studentList);
        System.out.println(studentList);
    }
}
