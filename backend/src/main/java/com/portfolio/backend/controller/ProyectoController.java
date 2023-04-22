
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.service.IProyectoService;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectServ;
    
    @GetMapping("/traer")
    public List<Proyecto> verProyectos(){
        return proyectServ.verProyectos();
    }
    
    @PostMapping("/crear")
    public String crearProyecto(@RequestBody Proyecto pro){
        proyectServ.crearProyecto(pro);
        return "Proyecto creado correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarProyecto (@PathVariable Long id){
        proyectServ.borrarProyecto(id);
    }
    
    @PutMapping("/editar/{id}")
    public Proyecto editarProyecto(@PathVariable Long id,
                                 @RequestParam("nombreproyecto") String nuevoNombreproyecto,
                                 @RequestParam("descripcion") String nuevaDescripcion,
                                 @RequestParam("link") String nuevoLink,
                                 @RequestParam("img") String nuevaImg){
        
        Proyecto pro = proyectServ.buscarProyecto(id);
        
        pro.setNombreproyecto(nuevoNombreproyecto);
        pro.setDescripcion(nuevaDescripcion);
        pro.setLink(nuevoLink);
        pro.setImg(nuevaImg);
        
        proyectServ.crearProyecto(pro);
        return pro;
    }
}
