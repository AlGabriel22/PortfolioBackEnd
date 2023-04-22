
package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencias() {
        List<Experiencia> listaExperiencias = expRepo.findAll();
        return listaExperiencias;
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        Experiencia exp = expRepo.findById(id).orElse(null);
        return exp;
    }

    @Override
    public void editarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }
    
}
