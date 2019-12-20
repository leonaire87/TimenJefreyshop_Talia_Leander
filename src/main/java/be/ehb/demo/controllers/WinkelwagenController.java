package be.ehb.demo.controllers;

import be.ehb.demo.model.Dierenproduct;
import be.ehb.demo.model.DierenproductDAO;
//import be.ehb.demo.model.WinkelwagenDAO;
import be.ehb.demo.model.Klant;
import be.ehb.demo.model.KlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@Controller
public class WinkelwagenController {

    @Autowired
    DierenproductDAO dao;
    @Autowired
    KlantDAO daoklant;


    @GetMapping(value = "/winkelwagen")
    public String showWinkelwagen(ModelMap map){
        return "winkelwagen";
    }


    //alle code voor onderdeel klant

        // modelattribute voor een nieuwe klant
        @ModelAttribute(value ="nKlant")
        public Klant klantToSave(){
            return new Klant();
        }

        //om ordergegevens van persoon te kunnen verwerken

        @RequestMapping(value = "/winkelwagen/klant", method = RequestMethod.POST)
        public String saveKlant(ModelMap map, @ModelAttribute("nKlant")@Valid Klant nKlant, BindingResult bindingResult) {
            if (bindingResult.hasErrors())
                return "winkelwagen";
            daoklant.save(nKlant);
            return "redirect:/orderbevestiging";
        }




    //alle code voor onderdeel cart

        //list aangemaakt
        static ArrayList<Dierenproduct> cart = new ArrayList<Dierenproduct>();

        //geeft winkelwagen weer
        @ModelAttribute(value = "toonWinkelwagen")
        public ArrayList<Dierenproduct> toonWinkelwagen() {
            return cart;
        }

        //om een product toe te voegen aan cart
        @GetMapping("/winkelwagen/add/{id}")
        public String addProduct(@PathVariable("id") int id){
            WinkelwagenController.cart.add(dao.findById(id).get());
            return "redirect:/index";
        }
        //om de winkelwagen te legen
        @GetMapping(value="/winkelwagen/wis")
        public String clearCart(){
            cart.clear();
            return "redirect:/orderbevestiging";
        }
}
