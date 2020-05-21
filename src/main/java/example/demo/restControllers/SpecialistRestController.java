package example.demo.restControllers;


import example.demo.entity.Specialist;
import example.demo.repos.SpecialistRepo;
import example.demo.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "api/specialist")
public class SpecialistRestController {

    @Autowired
    private SpecialistService specialistService;

    @RequestMapping( value = "find/{id}",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Specialist> find(@PathVariable("id") int id){
        try {
            return new ResponseEntity<Specialist>(specialistService.find(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Specialist>(HttpStatus.BAD_REQUEST);
        }
    }


}