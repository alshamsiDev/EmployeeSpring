package com.example.employeessoftwarespring;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EmployeesController {
    protected List<Employee> employees = new ArrayList<Employee>();

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody @Valid Employee employee, Errors errors) {
        System.out.println(errors);
        if (errors.hasErrors()) {
            System.out.println("Im Inside");
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(201).body("New Employee Added Successfully");
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable int id, @RequestBody @Valid Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("Im Inside");
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(id, employee);
        return ResponseEntity.status(201).body("New Employee Added Successfully");
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity destroyEmployee(@PathVariable int id) {
        employees.remove(id);
        return ResponseEntity.status(20).body("ok");

    }
}
