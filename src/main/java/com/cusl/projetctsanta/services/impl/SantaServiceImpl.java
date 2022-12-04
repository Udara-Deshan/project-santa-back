package com.cusl.projetctsanta.services.impl;

import com.cusl.projetctsanta.dto.ResultDTO;
import com.cusl.projetctsanta.entity.Santa;
import com.cusl.projetctsanta.repo.SantaRepo;
import com.cusl.projetctsanta.services.SantaService;
import lombok.SneakyThrows;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 12/2/2022
 **/

@Service
public class SantaServiceImpl implements SantaService {

    @Autowired
    private SantaRepo santaRepo;

    @Override
    public int getCount(int id) {
        return santaRepo.getCount(id);
    }

    @SneakyThrows
    @Override
    @Transactional
    @Modifying
    public ResultDTO selectSanta(int number, int id) {
        List<Santa> eligibleList = santaRepo.getEligibleList(id);
        if (eligibleList.size()>=number){
            Santa santaSelected = eligibleList.get(number);
            if (santaRepo.existsById(id)) {
                Santa byId = santaRepo.getById(id);
                byId.setRefID(santaSelected.getId());
                 santaRepo.saveAndFlush(byId);
                return new ResultDTO(santaSelected.getEmail(),santaSelected.getName());
            }
//            santaRepo.setSenta(santaSelected.getEmail(),santaSelected.getRefID());
        }else {
            throw new Exception();
        }

        return null;
    }
}
