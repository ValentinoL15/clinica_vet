package com.veterinaria.clinicaVeterinaria.server;

import com.veterinaria.clinicaVeterinaria.dto.DuenioMascoDTO;
import com.veterinaria.clinicaVeterinaria.model.Mascota;
import java.util.List;

public interface IMascotaService {
    
     public List<Mascota> getMascotas();
    
    public Mascota getMascota(Long id);
    
    public void saveMascota(Mascota masco);
    
    public void deleteMascota(Long id);
    
    public void editMascota(Mascota masco);
    
    public List<Mascota> getCaniches();
    
    public List<DuenioMascoDTO> getMascoDuenios();
    
    
}
