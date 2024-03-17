/*package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repositorio.PersonaRepository;
import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.ProductosPK;



@Controller
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public String personas(Model model) {
        model.addAttribute("personas",personaRepository.darPersona());
        return "personas";
    
}
    @GetMapping("/personas/new")
    public String personaForm(Model model){
        model.addAttribute("persona", new Persona() {
            
        });
        return "personaNuevo";

    }

    @PostMapping("/personas/new/save")
    public String personaGuardar(@ModelAttribute Persona persona){
      personaRepository.insertarPersona(persona.getNumeroDocumento());
      return "redirect:/personas";
    }

    @GetMapping("/personas/{id}/edit")
    public String personaEditarForm(@PathVariable("id") int id, Model model){
        Persona persona = personaRepository.darPersona(id);
        if (persona != null){
            model.addAttribute("persona", persona);
            return "personaEditar";}
            else{
                return "redirect:/personas";
            }

    }
    @PostMapping("/personas/{id}/edit/save")
    public String personaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Persona persona){
        personaRepository.actualizarPersona(id,persona.getNumeroDocumento());
        return "redirect:/personas";


    }

    @GetMapping("/personas/{id}/delete")
    public String personaEliminar(@PathVariable("id" )int id){
        personaRepository.eliminarPersona(id);
        return "redirect:/personas";

    }
    }
    */