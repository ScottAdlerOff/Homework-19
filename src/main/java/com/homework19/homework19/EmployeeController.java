package com.homework19.homework19;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceIntf employeeServiceIntf;

    public EmployeeController(EmployeeServiceIntf employeeServiceIntf) {
        this.employeeServiceIntf = employeeServiceIntf;
    }
    @GetMapping(path = "/add")
    public String addEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        try {
            return "Сотрудник: " + firstName + " " + lastName + " успешно добавлен";
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            e.printStackTrace();
            return "Сотрудник уже есть в базе или хранилище переполнено";
        }
    }
    @GetMapping(path = "/remove")
    public String removeEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        try {
        return "Сотрудник: " + firstName + " " + lastName + " успешно удален";
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Сотрудник не найден в базе данных";
        }
    }
    @GetMapping(path = "/find")
    public String findEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        try {
        return "Сотрудник: " + firstName + " " + lastName;
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Сотрудник не найден в базе данных";
        }
    }
    @GetMapping("/list")
    public List<Employee> employees() {
        return employeeServiceIntf.employees();
    }
}