package example.demo.controllers;


import example.demo.entity.Question;
import example.demo.entity.Specialist;
import example.demo.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionRepo questionRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String questionList(ModelMap modelMap){
        modelMap.put("question" ,questionRepo.findAll());
        return "question/questions";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable(value = "id") int id, Model model){
        Question question = questionRepo.findById(id).orElseThrow(IllegalStateException::new);
        questionRepo.delete(question);
        return "redirect: ";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String questionAdd(HttpServletRequest request){
        Question question = new Question();
        question.setDay(request.getParameter("day").trim());
        question.setText(request.getParameter("text").trim());
        questionRepo.save(question);
        return "redirect: ";
    }

}
