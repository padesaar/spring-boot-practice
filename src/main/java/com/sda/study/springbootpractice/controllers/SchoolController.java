package com.sda.study.springbootpractice.controllers;

import com.sda.study.springbootpractice.exceptions.CourseNotFoundException;
import com.sda.study.springbootpractice.exceptions.SchoolAlreadyExistsException;
import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String showSchoolListPage(Model model, @ModelAttribute("message") String message, @ModelAttribute("messageType") String messageType) {
        model.addAttribute("schools", schoolService.findAllSchools());
        return "school/list-school";
    }

    @GetMapping("/{id}")
    public String showSchoolViewPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("school", schoolService.findSchoolById(id));
            return "school/view-school";
        } catch (SchoolNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            schoolService.deleteSchoolById(id);
            redirectAttributes.addFlashAttribute("message", String.format("School #id=%d deleted successfully", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/school";
        } catch (SchoolNotFoundException | CourseNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }

    private static String handleException(RedirectAttributes redirectAttributes, Exception e) {
        redirectAttributes.addFlashAttribute("message", e.getLocalizedMessage());
        redirectAttributes.addFlashAttribute("messageType", "error");
        return "redirect:/school";
    }
    @GetMapping("/restore/{id}")
    public String restoreSchool(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            schoolService.restoreSchoolById(id);
            redirectAttributes.addFlashAttribute("message", String.format("School #id=%d restored successfully", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/school";
        } catch (SchoolNotFoundException | CourseNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }

    //to show the create-school page
    @GetMapping("/create")
    public String showCreateSchoolPage(@ModelAttribute("school") School school,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType) {
        return "school/create-school";
    }

    //called when we press submit button in the create-school form
    @PostMapping()
    public String createSchool(School school, RedirectAttributes redirectAttributes) {

        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            redirectAttributes.addFlashAttribute("message", String.format("School (%s) already exists!", school.getName()));
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/school/create-school";
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
            redirectAttributes.addFlashAttribute("message", String.format("School (%s) is added successfully!", school.getName()));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/school";
        }

    }

    @GetMapping("/update/{id}")
    public String showUpdateSchoolPage(@PathVariable Long id, RedirectAttributes redirectAttributes,
                                       @RequestParam(value="school", required=false) School school,
                                       Model model) {
        if (school == null) {
            try {
                model.addAttribute("school", schoolService.findSchoolById(id));
            } catch (SchoolNotFoundException e) {
                return handleException(redirectAttributes, e);
            }
        }

        return "school/update-school";
    }

    @PostMapping("/update")
    public String updateSchool(School school, RedirectAttributes redirectAttributes) {
        try {
            schoolService.updateSchool(school);
            redirectAttributes.addFlashAttribute("message", String.format("School(id=%d) has been updated successfully!", school.getId()));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/school";
        } catch (SchoolNotFoundException e) {
            return handleException(redirectAttributes, e);
        }
    }

}