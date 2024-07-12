package com.veterinaria.clinicaVeterinaria.server;

import com.veterinaria.clinicaVeterinaria.dto.DuenioMascoDTO;
import com.veterinaria.clinicaVeterinaria.model.Duenio;
import java.util.List;

public interface IDuenioService {
    
    public List<Duenio> getDuenios();
    
    public Duenio getDuenio(Long id);
    
    public void saveDuenio(Duenio duenio);
    
    public void deleteDuenio(Long id);
    
    public void editDuenio(Duenio duenio);
    
   
    
}
