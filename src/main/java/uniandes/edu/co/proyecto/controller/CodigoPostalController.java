package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repositorio.CodigoPostalRepository;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;



@Controller
public class CodigoPostalController {

    @Autowired
    private CodigoPostalRepository codigoPostalRepository;

    @GetMapping("/codigoPostales")
    public String codigoPostales(Model model) {
        model.addAttribute("codigoPostales",codigoPostalRepository.getCodigoPostal());
        return "codigoPostales";
    
}
    @GetMapping("/codigoPostales/new")
    public String codigoPostalForm(Model model){
        model.addAttribute("codigoPostal", new CodigoPostal() {
            
        });
        return "codigoPostalNuevo";

    }

    @PostMapping("/codigoPostales/new/save")
    public String codigoPostalGuardar(@ModelAttribute CodigoPostal codigoPostal){
      codigoPostalRepository.insertarCodigoPostal(codigoPostal.getCodigo(),codigoPostal.getCiudad());
      return "redirect:/codigoPostales";
    }

    @GetMapping("/codigoPostales/{id}/edit")
    public String codigoPostalEditarForm(@PathVariable("id") Integer id, Model model){
        CodigoPostal codigoPostal = codigoPostalRepository.getCodigoPostal(id);
        if (codigoPostal != null){
            model.addAttribute("codigoPostal", codigoPostal);
            return "codigoPostalEditar";}
            else{
                return "redirect:/codigoPostales";
            }

    }
    @PostMapping("/codigoPostales/{id}/edit/save")
    public String codigoPostalEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute CodigoPostal codigoPostal){
        codigoPostalRepository.actualizarCodigoPostal(id,codigoPostal.getCodigo(),codigoPostal.getCiudad());
        return "redirect:/codigoPostales";


    }

    @GetMapping("/codigoPostales/{id}/delete")
    public String codigoPostalEliminar(@PathVariable("id" )Integer id){
        codigoPostalRepository.eliminarCodigoPostal(id);
        return "redirect:/codigoPostales";

    }
    }