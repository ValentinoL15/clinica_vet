package com.veterinaria.clinicaVeterinaria.controller;

import com.veterinaria.clinicaVeterinaria.dto.DuenioMascoDTO;
import com.veterinaria.clinicaVeterinaria.model.Mascota;
import com.veterinaria.clinicaVeterinaria.server.IMascotaService;
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
public class MascotaController {
    
    @Autowired
    private IMascotaService mascoServ;
    
    @GetMapping("/traer/mascotas")
    public List<Mascota> getMascotas() {
        return mascoServ.getMascotas();
    }
    
    @GetMapping("/traer/mascota/{id}")
    public Mascota getMascota(@PathVariable Long id){
        return mascoServ.getMascota(id);
    }
    
    @PostMapping("/crear/mascota")
    public String crearMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
        
        return "la mascota ha sido creada correctamente";
    }
    
    @DeleteMapping("/eliminar/mascota/{id}")
    public String borrarMascota(@PathVariable Long id) {
        mascoServ.deleteMascota(id);
        
        return "La mascota ha sido eliminada correctamente";
    }
    
    @PutMapping("/editar/mascota")
    public Mascota editarMascota(@RequestBody Mascota masco){
        mascoServ.editMascota(masco);
        
        return mascoServ.getMascota(masco.getId_mascota());
    }
    
    @GetMapping("/caniche")
    public List<Mascota> getCaniches(){
        return mascoServ.getCaniches();
    }
    
    @GetMapping("/traer/dueniomasco")
    public List<DuenioMascoDTO> getDuenioMasco(){
        return mascoServ.getMascoDuenios();
    }
    
}
