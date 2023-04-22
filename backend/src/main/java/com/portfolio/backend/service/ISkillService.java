
package com.portfolio.backend.service;

import com.portfolio.backend.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List<Skill> verSkills();
    
    public void crearSkill(Skill sk);
    
    public void borrarSkill(Long id);
    
    public Skill buscarSkill(Long id);
}
