package com.veterinaria.clinicaVeterinaria.controller;

import com.veterinaria.clinicaVeterinaria.dto.DuenioMascoDTO;
import com.veterinaria.clinicaVeterinaria.model.Duenio;
import com.veterinaria.clinicaVeterinaria.server.IDuenioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuenioController {
    
    @Autowired
    private IDuenioService duenioServ;
    
    @GetMapping("/traer/duenios")
    public List<Duenio> getDuenios() {
        List <Duenio> listaDuenios = duenioServ.getDuenios();
        return listaDuenios;
    }
    
    @GetMapping("/traer/duenio/{id}")
    public Duenio getDuenio(@PathVariable Long id){
        return duenioServ.getDuenio(id);
    }
    
    @PostMapping("/crear/duenio")
    public String crearDuenio(@RequestBody Duenio duenio) {
        duenioServ.saveDuenio(duenio);
        
        return "El duenio se ha creado correctamente";
    }
    
    @DeleteMapping("/eliminar/duenio/{id}")
    public String borrarDuenio(@PathVariable Long id){
        duenioServ.deleteDuenio(id);
        
        return "El duenio se ha eliminado con exito";
    }   
    
    @PutMapping("/editar/duenio")
    public Duenio editarDuenio(@RequestBody Duenio duenio){
        duenioServ.editDuenio(duenio);
        
        return duenioServ.getDuenio(duenio.getId_duenio());
    }
    
}
