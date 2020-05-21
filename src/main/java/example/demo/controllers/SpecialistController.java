package example.demo.controllers;


import example.demo.entity.Specialist;
import example.demo.repos.SpecialistRepo;
import example.demo.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "specialist")
public class SpecialistController {

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private SpecialistRepo specialistRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("specialist", specialistService.findAll());
        return "specialist/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(HttpServletRequest request){
        Specialist specialist = new Specialist();
        specialist.setName(request.getParameter("name").trim());
        specialist.setSurname(request.getParameter("surname").trim());
        specialist.setSlack(request.getParameter("slack").trim());
        specialistService.save(specialist);
        return "redirect: ";
    }


    @GetMapping("/{id}")
    public String delete(@PathVariable(value = "id") int id, Model model){
        Specialist specialist = specialistRepo.findById(id).orElseThrow(IllegalStateException::new);
        specialistRepo.delete(specialist);
        return "redirect: ";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Specialist specialist = specialistService.find(id);
        specialist.setName(request.getParameter("name").trim());
        specialist.setSurname(request.getParameter("surname").trim());
        specialist.setSlack(request.getParameter("slack").trim());
        specialistService.save(specialist);
        return "redirect: ";
    }

}
