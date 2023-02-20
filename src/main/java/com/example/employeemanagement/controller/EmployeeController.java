package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeService();

    @GetMapping()
    public String index(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Employee employee) {
        employee.setId((int) (Math.random() * 10000));
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Employee employee) {
        employeeService.update(employee.getId(), employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Employee employee, RedirectAttributes redirect) {
        employeeService.remove(employee.getId());
        redirect.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/view";
    }
}
