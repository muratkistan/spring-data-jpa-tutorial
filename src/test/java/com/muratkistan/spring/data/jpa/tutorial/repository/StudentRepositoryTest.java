package com.muratkistan.spring.data.jpa.tutorial.repository;

import com.muratkistan.spring.data.jpa.tutorial.entity.Guardian;
import com.muratkistan.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .mobile("9999999999")
                .email("nikhil@gmail.com")
                .build();
        Student student = Student.builder()
                .emailId("shivam@gmail.com")
                .firstName("Shivam")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public  void  printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student List : "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Shivam");
        System.out.println("students = "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");
        System.out.println("students = "+ students);
    }

    @Test
    public void  printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = "+ students);
    }


    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("shabbir@gmail.com");
        System.out.println("student : "+student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("shabbir@gmail.com");
        System.out.println("FirstName : "+firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
        System.out.println("student : "+student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeParam("shivam@gmail.com");
        System.out.println("student : "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("shabbir dawoodi","shabbir@gmail.com");

    }

}