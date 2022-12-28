package com.stu.stuManag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    // Add student .................................................................
    String addstu(Student student){
        String result = studentRepository.addstuFrom(student);
        return result;
    }
    // GET STU BY ID ................................................................
    Student getstubyId(Integer id){
        Student stu=studentRepository.getstuByID(id);
        return stu;
    }
    // GET STU BY NAME ...............................................................
    Student getstudentbyname(String name){
       Student s = studentRepository.getstubyname(name);
            return s;
        }
     // UPDATE STU ............................
     Student updatestudent(Student stu){
        Student s= studentRepository.updatestu(stu);
        return  s;
     }
     /// DELETE STUDENT .............................
    String delstu(int id){
        String s= studentRepository.delstu(id);
        return s;
    }
    ////  list stu...............................
    List<Student> list(){
        List<Student> list=studentRepository.getAllStudent();
        return list;
    }
}
