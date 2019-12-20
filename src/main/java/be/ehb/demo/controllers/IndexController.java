package be.ehb.demo.controllers;

import be.ehb.demo.model.Dierenproduct;
import be.ehb.demo.model.DierenproductDAO;
import be.ehb.demo.model.Klant;
import be.ehb.demo.model.KlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    DierenproductDAO dao;

    //om alle producten te vinden
    @ModelAttribute(value = "all")
    public Iterable<Dierenproduct> findAll() {
        return dao.findAll();
    }

    //link naar indexpagina, about,orderbevestiging, winkelwagen
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String showAbout(ModelMap map) {
        return "about";
    }

    @RequestMapping(value = {"/orderbevestiging"}, method = RequestMethod.GET)
    public String showOrderbevestiging(ModelMap map) {
        return "orderbevestiging";
    }



    //methode om te zoeken op soort
    @RequestMapping(value = { "/{dierenSoort}", "/index/{dierenSoort}"} ,method = RequestMethod.GET)
    public String findByDierenSoort (ModelMap map, @PathVariable("dierenSoort") String dierenSoort){
        map.addAttribute("all",dao.findByDierenSoort(dierenSoort));
        return "index";
    }
}

