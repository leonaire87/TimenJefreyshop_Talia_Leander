package be.ehb.demo.controllers;

import be.ehb.demo.model.Dierenproducten;
import be.ehb.demo.model.DierenproductenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    DierenproductenDAO dao;

    @ModelAttribute(value = "all")
    public Iterable<Dierenproducten> findAll(){
        return dao.findAll();
    }
    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
    public String showIndex (ModelMap map){
        return "index";
    }
}
