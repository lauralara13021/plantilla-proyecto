package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repositorio.DireccionRepository;
import uniandes.edu.co.proyecto.modelo.Direccion;




@Controller
public class DireccionController {

    @Autowired
    private DireccionRepository direccionRepository;

    @GetMapping("/direcciones")
    public String direcciones(Model model) {
        model.addAttribute("direcciones",direccionRepository.getDireccion());
        return "direcciones";
    
}
    @GetMapping("/direcciones/new")
    public String direccionForm(Model model){
        model.addAttribute("direccion", new Direccion() {
            
        });
        return "direccionNuevo";

    }

    @PostMapping("/direcciones/new/save")
    public String direccionGuardar(@ModelAttribute Direccion direccion){
      direccionRepository.insertarDireccion(direccion.getDireccion(),direccion.getCodigoPostal());
      return "redirect:/direcciones";
    }

    @GetMapping("/direcciones/{id}/edit")
    public String direccionEditarForm(@PathVariable("id") int id, Model model){
        Direccion direccion = direccionRepository.getDireccion(id);
        if (direccion != null){
            model.addAttribute("direccion", direccion);
            return "direccionEditar";}
            else{
                return "redirect:/direcciones";
            }

    }
    @PostMapping("/direcciones/{id}/edit/save")
    public String direccionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Direccion direccion){
        direccionRepository.actualizarDireccion(id,direccion.getDireccion(),direccion.getCodigoPostal());
        return "redirect:/direcciones";


    }

    @GetMapping("/direcciones/{id}/delete")
    public String direccionEliminar(@PathVariable("id" )int id){
        direccionRepository.eliminarDireccion(id);
        return "redirect:/direcciones";

    }
    }