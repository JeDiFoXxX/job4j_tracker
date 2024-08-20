package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setLastName("Kennedy");
        student.setPatronymic("Fitzgerald");
        student.setGroup(35);
        student.setDate(new Date(17, 4, 29));

        System.out.printf("%s %s %s\n№ group - %d\nDate of receipt - %s", student.getName(), student.getLastName(),
                            student.getPatronymic(), student.getGroup(), student.getDate());
    }
}
