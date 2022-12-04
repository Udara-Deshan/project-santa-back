package com.cusl.projetctsanta.services;

import com.cusl.projetctsanta.dto.ResultDTO;
import com.cusl.projetctsanta.entity.Santa;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 12/2/2022
 **/
public interface SantaService {

    int getCount(int id);

    ResultDTO selectSanta(int number, int id);

}
