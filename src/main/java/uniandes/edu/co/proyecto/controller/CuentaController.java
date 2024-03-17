package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Repositorio.CuentaRepository;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.ProductosPK;



@Controller
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        model.addAttribute("cuentas",cuentaRepository.getCuenta());
        return "cuentas";
    
}
    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model){
        model.addAttribute("cuenta", new Cuenta() {
            
        });
        return "cuentaNuevo";

    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta){
      cuentaRepository.insertarCuenta(cuenta.getEstado(),cuenta.getTipo(), cuenta.getDinero());
      return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") ProductosPK id, Model model){
        Cuenta cuenta = cuentaRepository.getCuenta(id);
        if (cuenta != null){
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";}
            else{
                return "redirect:/cuentas";
            }

    }
    @PostMapping("/cuentas/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") ProductosPK id, @ModelAttribute Cuenta cuenta){
        cuentaRepository.actualizarCuenta(id,cuenta.getEstado(),cuenta.getTipo(), cuenta.getDinero());
        return "redirect:/cuentas";


    }

    @GetMapping("/cuentas/{id}/delete")
    public String cuentaEliminar(@PathVariable("id" )ProductosPK id){
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";

    }
    }
    