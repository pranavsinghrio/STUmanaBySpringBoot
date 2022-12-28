package com.stu.stuManag;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
// ADD STUDENT ............................................
public class StudentRepository {
    HashMap<Integer, Student> studb = new HashMap<>();

    String addstuFrom(Student student) {
        int key = student.id;
        studb.put(key, student);
        return "Successfully added";
    }

    // GET STUDENT .............................
    Student getstuByID(int id) {
        if (studb.containsKey(id)) {
            return studb.get(id);
        } else {
            return null;
        }
    }

    // GET STUDENT BY NAME............................
    Student getstubyname(String searchname) {
        for (Student s : studb.values()) {
            if (s.name.equals(searchname)) {
                return s;
            }
        }
        return null;
    }

    // UPDATE STUDENT ....................
    Student updatestu(Student student) {
        int key = student.id;
        studb.put(key, student);
        return student;
    }

    /// delet student.......................
    String delstu(int id) {
        if (studb.containsKey(id)) {
            studb.remove(id);
            return "Delete successfully";
        } else {
            return "Student not found";
        }
    }
    // list student ..... .

    List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();

        for (Map.Entry<Integer, Student> stu : studb.entrySet()) {
            int id = stu.getKey();
            Student s = stu.getValue();
            list.add(s);
        }
        return list;
    }
}
