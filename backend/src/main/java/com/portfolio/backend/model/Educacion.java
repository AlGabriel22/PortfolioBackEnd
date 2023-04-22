
package com.portfolio.backend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEdu;
    
    private String titulo;
    private String institucion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    
    private String logoimg;

    public Educacion() {
    }

    public Educacion(String titulo, String institucion, Date inicio, Date fin, String logoimg) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.inicio = inicio;
        this.fin = fin;
        this.logoimg = logoimg;
    }   
}
