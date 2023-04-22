
package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private ProyectoRepository proyectRepo;
    
    @Override
    public List<Proyecto> verProyectos() {
        List<Proyecto> listaProyectos = proyectRepo.findAll();
        return listaProyectos;
    }

    @Override
    public void crearProyecto(Proyecto pro) {
        proyectRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        Proyecto pro = proyectRepo.findById(id).orElse(null);
        return pro;
    }
    
}
