package com.codegym.demo_spring_data_jpa_c07.controller;



import com.codegym.demo_spring_data_jpa_c07.model.Student;
import com.codegym.demo_spring_data_jpa_c07.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/create")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("classList", new String[]{"c05","C06","C07","C08"});
        model.addAttribute("student",student);
        return "/student/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes attributes){
        studentService.add(student);
        attributes.addFlashAttribute("mess","add new success");
        return "redirect:/student";
    }
//    @GetMapping(value = "")
//    public String showList(@PageableDefault(page = 0,size = 2,sort ="name",direction = Sort.Direction.ASC) Pageable pageable,
//                           @RequestParam(defaultValue = "") String searchName,
////                          @RequestParam Optional<String> searchName,
//                           Model model){
////        String searchValue ="";
////        if (searchName.isPresent()){
////            searchValue = searchName.get();
////        }
//        Page<Student> studentPage = studentService.findAll(searchName,pageable);
//        model.addAttribute("studentPage",studentPage);
//        model.addAttribute("searchName",searchName);
//        return "student/list";
//    }
    @GetMapping(value = "")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String searchName,
                           Model model){
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending()
                                                             .and(Sort.by("gender").descending()));
        Page<Student> studentPage = studentService.findAll(searchName,pageable);
        model.addAttribute("studentPage",studentPage);
        model.addAttribute("searchName",searchName);
        return "student/list";
    }



    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id",required = false,defaultValue = "-1") int detailId, Model model){
        Student student = studentService.findById(detailId);
        model.addAttribute("student",student);
        return "student/detail";
    }
    @GetMapping("/detail2/{id}")
    // có thể regex
//    @GetMapping("/detail2/{id:[1-2]}")
    public String detail2(@PathVariable(name = "id") int detailId, Model model){
        Student student = studentService.findById(detailId);
        model.addAttribute("student",student);
        return "student/detail";
    }
}
