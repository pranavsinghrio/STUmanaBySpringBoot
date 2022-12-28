package com.stu.stuManag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController  //telling the java application this class contains api end
public class StudentController {
    @Autowired  // automaticalay takes care of stu obj creation
    StudentService studentService;

    // add stu...................................................................
    @PostMapping("add_stu")
    public ResponseEntity<String>addStu(@RequestBody()Student student){

        String response =studentService.addstu(student);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
   // get stu  .............................................................

    // 1.) by id using get mapping.......
    @GetMapping("get_stu_id")
    public ResponseEntity<Student>getstu(@RequestParam("id")Integer id){
        Student s= studentService.getstubyId(id);
        if(s==null) {
            return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
    }

    // 2.) by id using path.......

    @GetMapping("get_stu_by_path/{id}")
    public ResponseEntity<Student> getStuByPath(@PathVariable("id")Integer id){
        Student s= studentService.getstubyId(id);
        if(s==null) {
            return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
    }

    // 3.) by name........
    @GetMapping("stu_by_name")
    public ResponseEntity<Student> getstubyname(@RequestParam("name")String name){
        Student s= studentService.getstudentbyname(name);
        if(s==null) {
            return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
    }
    // UPDATE STUDENT .......................................
    @PutMapping("update_stu")
    public ResponseEntity<Student> updatestu(@RequestBody()Student stu){
        Student s= studentService.updatestudent(stu);
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }

    // DELETE STUDENT .......................................
    @DeleteMapping("del_stu")
    public ResponseEntity<String> deletstu(@RequestParam("id")Integer id){
        String s= studentService.delstu(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("get_AllStudents")
    public  ResponseEntity<List<Student> >allstu(){
        List<Student> list=studentService.list();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
