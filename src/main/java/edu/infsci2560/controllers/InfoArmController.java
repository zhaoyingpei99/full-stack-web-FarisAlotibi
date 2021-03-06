/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.controllers;

import edu.infsci2560.models.InfoArm;
import edu.infsci2560.repositories.InfoArmRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author kolobj
 */
@Controller
public class InfoArmController {
    @Autowired
    private InfoArmRepository repository;
    
    @RequestMapping(value = "infoArms", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("infoArms", "infoArms", repository.findAll());
    }
    
    @RequestMapping(value = "infoArms/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid InfoArm infoArm, BindingResult result) {
        // infoArm.getOrgnization().setInfoArm(infoArm);
        repository.save(infoArm);
        return new ModelAndView("infoArms", "infoArms", repository.findAll());
    }

    @RequestMapping(value = "infoArms/delete/{id}", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView delete(@PathVariable("id") Long id) {
        // repository.delete(repository.findOne(id));
        // @ModelAttribute;
        repository.deleteById(id);
        // return new ModelAndView("infoArms", "infoArms", repository.findAll());
        return new ModelAndView("redirect:/infoArms");
    }

    @RequestMapping(value = "infoArmsUpdate/update/{id}", method = RequestMethod.GET)
    public ModelAndView getRecord(@PathVariable("id") Long id) {
  
        InfoArm infoArm = repository.findById(id);
        // infoArm.getOrgnization().setInfoArm(infoArm);
        ModelAndView modelAndView = new ModelAndView("infoArmsUpdate");
        modelAndView.addObject("infoArm", infoArm);
        return modelAndView;
    }

    @RequestMapping(value = "infoArmsUpdate/update/{id}" , method =  RequestMethod.PUT)
    public ModelAndView create(@PathVariable("id") Long id, @ModelAttribute @Valid InfoArm infoArm, BindingResult result) {
        repository.save(infoArm);
        return new ModelAndView("redirect:/infoArms"); // inforArms template name
    }
    
}