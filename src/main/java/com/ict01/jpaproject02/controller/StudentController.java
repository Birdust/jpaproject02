package com.ict01.jpaproject02.controller;

import com.ict01.jpaproject02.ResourceNotFoundException;
import com.ict01.jpaproject02.model.Student;
import com.ict01.jpaproject02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController { // /user로 들어오는 요청을 모두 처리한다.

  // Service Constructor Dependency Injection
  // Service 클래스의 의존성 주입을 위한 생성자 주입
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService){
    this.studentService = studentService;
  }

  //http://localhost:8080/student/lists
  // [1] 전체 학생 정보 조회
  @GetMapping("/lists")
  public String lists(Model model){
    // GET method 이며 /user 요청을 처리한다.
    // (1) 모든 학생들을 가져온다.
    List<Student> students = studentService.lists();

    //(2) 가져온 Student Collection을 view로 전달한다.
    model.addAttribute("students", students);

    // (3)  학생 목록을 보여줄 뷰 페이지를 반환
    //http://localhost:8080/student/lists/WEB-INF/views/listStudents.jsp
    return "listStudents";
  }


  // [1-2]
  /*
  @ResponseBody
  public List<Student> lists() throws ClassNotFoundException, SQLException {
    List<Student> students = studentService.lists();
    return students;
  }

   */

  // [2] 학생 정보 등록 (Create) - 두 개인 이유 : 화면이 먼저 뷰폼으로 나온다. 입력값 폼테그 타입으로 받는 경우
  // [2-1] 학생 정보 등록 Form - 화면을 띄우는 맵핑 : getmapping -> show Form
  @GetMapping("/showForm")
  public String showForAdd(Model model){ // method를 마음대로 입력 가능하다. (GET method, /user 요청을 처리한다.)
    Student student = new Student();
    model.addAttribute("student", student);
    // WEB-INF/views/studentForm.jsp
    return "studentForm"; // view로 연결된다.
  }



  // [2-2] 학생 정보 저장 Action - postmapping(등록 - 데이터 입력하는 것 밖에 없다.)
  @PostMapping("/saveStudent")
  public String saveStudent(@ModelAttribute("student") Student student) {
    studentService.saveStudent(student);

    // 학생 정보를 등록한 후, 학생 목록 페이지로 리다이렉션
    return "redirect:/student/lists";
  }


  // [3] 학생 정보 수정 (Update)
  //  [3-1] 학생 정보 수정 Form을 보여주는 method
  @GetMapping("/updateForm")
  public String showFormUpdate(@RequestParam("studentId") int id, Model model) throws ResourceNotFoundException{
    Student student = studentService.getStudent(id);
    model.addAttribute("student", student);

    // 학생 정보 수정 폼을 표시하는 뷰 페이지로 이동
    return "updateForm";

  }


  // [3-2] 학생 정보 수정 Action
  @PostMapping("/updateStudent")
  public String updateStudent(@ModelAttribute("student") Student student) {
    studentService.saveStudent(student);

    // 학생 정보를 수정한 후, 학생 목록 페이지로 리다이렉션
    return "redirect:/student/lists";
  }







  // [4] 학생 정보 삭제
  @GetMapping("/delete")
  public String deleteStudent(@RequestParam("studentId") int id) throws ResourceNotFoundException {
    studentService.deleteStudent(id);

    // 학생 정보를 삭제한 후, 학생 목록 페이지로 리다이렉션
    return "redirect:/student/lists";
  }


}
