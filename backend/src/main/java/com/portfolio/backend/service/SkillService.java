
package com.portfolio.backend.service;

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillRepo;
    
    @Override
    public List<Skill> verSkills() {
        List<Skill> listaSkills = skillRepo.findAll();
        return listaSkills;
    }

    @Override
    public void crearSkill(Skill sk) {
        skillRepo.save(sk);
    }

    @Override
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        Skill sk = skillRepo.findById(id).orElse(null);
        return sk;
    }
    
}
