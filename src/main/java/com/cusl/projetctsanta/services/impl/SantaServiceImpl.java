package com.cusl.projetctsanta.services.impl;

import com.cusl.projetctsanta.repo.SantaRepo;
import com.cusl.projetctsanta.services.SantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 12/2/2022
 **/

@Service
public class SantaServiceImpl implements SantaService {

    @Autowired
    private SantaRepo santaRepo;

    @Override
    public int getCount() {
        return santaRepo.getCount();
    }

    @Override
    public boolean selectSanta(int n) {
        santaRepo.setSenta()
        return false;
    }
}
