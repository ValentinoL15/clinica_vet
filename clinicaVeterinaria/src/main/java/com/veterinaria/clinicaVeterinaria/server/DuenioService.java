package com.veterinaria.clinicaVeterinaria.server;

import com.veterinaria.clinicaVeterinaria.dto.DuenioMascoDTO;
import com.veterinaria.clinicaVeterinaria.model.Duenio;
import com.veterinaria.clinicaVeterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    private IDuenioRepository duenioRepo;
    
    @Override
    public List<Duenio> getDuenios() {
        List<Duenio> listaDuenios = duenioRepo.findAll();
       return listaDuenios;
    }

    @Override
    public Duenio getDuenio(Long id) {
       return duenioRepo.findById(id).orElse(null);
    }

    @Override
    public void saveDuenio(Duenio duenio) {
       duenioRepo.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepo.deleteById(id);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }

 
    
    
    
}
