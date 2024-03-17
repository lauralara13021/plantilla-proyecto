package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repositorio.PuntoDeAtencionRepository;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;
import uniandes.edu.co.proyecto.modelo.ProductosPK;



@Controller
public class PuntoDeAtencionController {

    @Autowired
    private PuntoDeAtencionRepository puntoDeAtencionRepository;

    @GetMapping("/puntoDeAtencions")
    public String puntoDeAtencions(Model model) {
        model.addAttribute("puntoDeAtencions",puntoDeAtencionRepository.getPuntoDeAtencion());
        return "puntoDeAtencions";
    
}
    @GetMapping("/puntoDeAtencions/new")
    public String puntoDeAtencionForm(Model model){
        model.addAttribute("puntoDeAtencion", new PuntoDeAtencion() {
            
        });
        return "puntoDeAtencionNuevo";

    }

    @PostMapping("/puntoDeAtencions/new/save")
    public String puntoDeAtencionGuardar(@ModelAttribute PuntoDeAtencion puntoDeAtencion){
      puntoDeAtencionRepository.insertarPuntoDeAtencion(puntoDeAtencion.getTipo(), puntoDeAtencion.getLocalizacion(), puntoDeAtencion.getOficina());
      return "redirect:/puntoDeAtencions";
    }

    @GetMapping("/puntoDeAtencions/{id}/edit")
    public String puntoDeAtencionEditarForm(@PathVariable("id") int id, Model model){
        PuntoDeAtencion puntoDeAtencion = puntoDeAtencionRepository.getPuntoDeAtencion(id);
        if (puntoDeAtencion != null){
            model.addAttribute("puntoDeAtencion", puntoDeAtencion);
            return "puntoDeAtencionEditar";}
            else{
                return "redirect:/puntoDeAtencions";
            }

    }
    @PostMapping("/puntoDeAtencions/{id}/edit/save")
    public String puntoDeAtencionEditarGuardar(@PathVariable("id") int id, @ModelAttribute PuntoDeAtencion puntoDeAtencion){
        puntoDeAtencionRepository.actualizarPuntoDeAtencion(id,puntoDeAtencion.getTipo(), puntoDeAtencion.getLocalizacion(), puntoDeAtencion.getOficina());
        return "redirect:/puntoDeAtencions";


    }

    @GetMapping("/puntoDeAtencions/{id}/delete")
    public String puntoDeAtencionEliminar(@PathVariable("id" )ProductosPK id){
        puntoDeAtencionRepository.eliminarPuntoDeAtencion(id);
        return "redirect:/puntoDeAtencions";

    }
    }
    