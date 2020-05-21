package example.demo.controllers;


import example.demo.entity.Employee;
import example.demo.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String employeeList(ModelMap modelMap){
        modelMap.put("employee", employeeRepo.findAll());
        return "employee/employee";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String employeeList(@PathVariable(value = "id") int id, ModelMap modelMap){
        Optional<Employee> employee = employeeRepo.findById(id);
        ArrayList<Employee> res = new ArrayList<>();
        employee.ifPresent(res::add);
        modelMap.put("employee", res);
        return "employee/employeeSingle";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(HttpServletRequest request){
        Employee employee = new Employee();
        employee.setName(request.getParameter("name").trim());
        employee.setSurname(request.getParameter("surname").trim());
        employee.setSlack(Integer.parseInt(request.getParameter("slack").trim()));
        employeeRepo.save(employee);
        return "redirect: ";
    }

}
