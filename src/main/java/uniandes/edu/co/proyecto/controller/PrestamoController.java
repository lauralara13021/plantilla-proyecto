package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repositorio.PrestamoRepository;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.ProductosPK;



@Controller
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute("prestamos",prestamoRepository.getPrestamo());
        return "prestamos";
    
}
    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model){
        model.addAttribute("prestamo", new Prestamo() {
            
        });
        return "prestamoNuevo";

    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo){
      prestamoRepository.insertarPrestamo(prestamo.getInteres(), prestamo.getCuotas(), prestamo.getEstado(), prestamo.getMonto(), prestamo.getDiaCorte());
      return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("id") ProductosPK id, Model model){
        Prestamo prestamo = prestamoRepository.getPrestamo(id);
        if (prestamo != null){
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";}
            else{
                return "redirect:/prestamos";
            }

    }
    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("id") ProductosPK id, @ModelAttribute Prestamo prestamo){
        prestamoRepository.actualizarPrestamo(id,prestamo.getInteres(), prestamo.getCuotas(), prestamo.getEstado(), prestamo.getMonto(), prestamo.getDiaCorte());
        return "redirect:/prestamos";


    }

    @GetMapping("/prestamos/{id}/delete")
    public String prestamoEliminar(@PathVariable("id" )ProductosPK id){
        prestamoRepository.eliminarPrestamo(id);
        return "redirect:/prestamos";

    }
    }
    


