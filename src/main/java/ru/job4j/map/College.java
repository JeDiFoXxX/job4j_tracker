package ru.job4j.map;

import java.util.Map;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.account().equals(account))
                .findFirst()
                .orElse(null);
    }

    public Subject findBySubjectName(String account, String name) {
        Student student = findByAccount(account);
        if (student != null) {
            return students.get(student)
                    .stream()
                    .filter(subject -> subject.name().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

}
