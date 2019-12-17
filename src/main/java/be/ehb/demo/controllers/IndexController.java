package be.ehb.demo.controllers;

import be.ehb.demo.model.Dierenproducten;
import be.ehb.demo.model.DierenproductenDAO;
import be.ehb.demo.model.Klant;
import be.ehb.demo.model.KlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    DierenproductenDAO dao;
    KlantDAO daoklant;

    @ModelAttribute(value = "all")
    public Iterable<Dierenproducten> findAll() {
        return dao.findAll();
    }

    // modelattribute voor een nieuwe klant
    @ModelAttribute(value ="nKlant")
    public Klant klantToSave(){
        return new Klant();
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }

    //link naar pagina about,orderbevestiging, winkelwagen

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String showAbout(ModelMap map) {
        return "about";
    }

    @RequestMapping(value = {"/orderbevestiging"}, method = RequestMethod.GET)
    public String showOrderbevestiging(ModelMap map) {
        return "orderbevestiging";
    }

    @RequestMapping(value = { "/winkelwagen"}, method = RequestMethod.GET)
    public String showWinkelwagen(ModelMap map) {
        return "winkelwagen";
    }




    //om ordergegevens van persoon te kunnen verwerken

    @RequestMapping(value = "/winkelwagen", method = RequestMethod.POST)
    public String saveKlant(@ModelAttribute("nKlant")@Valid Klant nKlant, BindingResult bindingResult){
        if (bindingResult.hasErrors())
        return "winkelwagen";
        daoklant.save(nKlant);
        return "redirect:/orderbevestiging";
    }
    //methode om te zoeken op soort

    @RequestMapping(value = { "/{dierenSoort}", "/index/{dierenSoort}"} ,method = RequestMethod.GET)
    public String findByDierenSoort (ModelMap map, @PathVariable("dierenSoort") String dierenSoort){
        map.addAttribute("all",dao.findByDierenSoort(dierenSoort));
        return "index";
    }

    @RequestMapping(value = { "/index/{id}"} ,method = RequestMethod.GET)
    public String findById (ModelMap map, @PathVariable("id") int id){
        map.addAttribute("winkelwagen",dao.findById(id).get());
        return "winkelwagen";
    }



}

