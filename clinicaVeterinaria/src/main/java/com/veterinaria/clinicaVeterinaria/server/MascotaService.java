package com.veterinaria.clinicaVeterinaria.server;

import com.veterinaria.clinicaVeterinaria.dto.DuenioMascoDTO;
import com.veterinaria.clinicaVeterinaria.model.Mascota;
import com.veterinaria.clinicaVeterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascoRepo;
    
    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public Mascota getMascota(Long id) {
       return mascoRepo.findById(id).orElse(null);
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepo.deleteById(id);
    }

    @Override
    public void editMascota(Mascota masco) {
        this.saveMascota(masco);
    }

    @Override
    public List<Mascota> getCaniches() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();
        
        for (Mascota masco : listaMascotas){
            if(masco.getEspecie().equalsIgnoreCase("perro") && masco.getRaza().equalsIgnoreCase("caniche")){
                listaCaniches.add(masco);
            }
        }
        return listaCaniches;
    }

    @Override
    public List<DuenioMascoDTO> getMascoDuenios() {
        List <Mascota> listaMascotas = this.getMascotas();
        List<DuenioMascoDTO> listaDuenioMasco = new ArrayList<DuenioMascoDTO>();
        DuenioMascoDTO masco_duenio = new DuenioMascoDTO();
        
        for (Mascota masco : listaMascotas) {
            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());
            
            listaDuenioMasco.add(masco_duenio);
            masco_duenio = new DuenioMascoDTO();
        }
        
        return listaDuenioMasco;
    }

  
    
}
