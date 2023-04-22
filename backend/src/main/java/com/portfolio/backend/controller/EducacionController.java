
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.service.IEducacionService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    private IEducacionService eduServ;
    
    @GetMapping("/lista")
    public List<Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @PostMapping("/crear")
    public String crearEducacion(@RequestBody Educacion edu){
        eduServ.crearEducacion(edu);
        return "Educacion creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarEducacion(@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping("/editar/{id}")
    public Educacion editarEducacion(@PathVariable Long id,
                                 @RequestParam("titulo") String nuevoTitulo,
                                 @RequestParam("institucion") String nuevaInstitucion,
                                 @RequestParam("inicio") Date nuevoInicio,
                                 @RequestParam("fin") Date nuevoFin,
                                 @RequestParam("logoimg") String nuevoLogoimg){
        
        Educacion edu = eduServ.buscarEducacion(id);
        
        edu.setTitulo(nuevoTitulo);
        edu.setInstitucion(nuevaInstitucion);
        edu.setInicio(nuevoInicio);
        edu.setFin(nuevoFin);
        edu.setLogoimg(nuevoLogoimg);
        
        eduServ.crearEducacion(edu);
        return edu;
    }
}
