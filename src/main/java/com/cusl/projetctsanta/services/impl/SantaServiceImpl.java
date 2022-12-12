package com.cusl.projetctsanta.services.impl;

import com.cusl.projetctsanta.dto.MyGifterResultDTO;
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

    @SneakyThrows
    @Override
    public int getCount(String memberNo, String name) {
        System.out.println("name = " + name);
        System.out.println("namesss = " + santaRepo.verifyUser(memberNo, name));
        if (santaRepo.verifyUser(memberNo, name) > 0) {
            if (santaRepo.getReferenceById(memberNo).getRefID() == null) {
                return santaRepo.getCount(memberNo);
            } else {
                return -1;
            }
        } else {
            throw new RuntimeException("Member Number Or Name is Incorrect Try Again");
        }

    }

    @SneakyThrows
    @Override
    @Transactional
    @Modifying
    public ResultDTO selectSanta(int number, String memberNo, String name) {
        System.out.println("name = " + name);
        System.out.println("namesss = " + santaRepo.verifyUser(memberNo, name));
        if (santaRepo.verifyUser(memberNo, name) > 0) {
            if (santaRepo.existsById(memberNo) && santaRepo.getCount(memberNo) > 0) {
                List<Santa> eligibleList = santaRepo.getEligibleList(memberNo);
                if (eligibleList.size() >= number) {
                    Santa santaSelected = eligibleList.get(number - 1);
                    Santa byId = santaRepo.getReferenceById(memberNo);
                    byId.setRefID(santaSelected.getMemberNo());
                    santaRepo.saveAndFlush(byId);
                    return new ResultDTO(santaSelected.getFullName(), "");
//            santaRepo.setSenta(santaSelected.getEmail(),santaSelected.getRefID());
                } else {
                    throw new RuntimeException("Member Number Or Name is Incorrect Try Again");
                }
            }
            return null;
        } else {
            throw new RuntimeException("Member Number Or Name is Incorrect Try Again");
        }

    }

    @SneakyThrows
    @Override
    public MyGifterResultDTO myGifter(String memberNo, String name) {
        System.out.println("name = " + name);
        System.out.println("namesss = " + santaRepo.verifyUser(memberNo, name));

        if (santaRepo.verifyUser(memberNo, name) > 0) {
            if (santaRepo.existsById(memberNo)) {
                Santa referenceById = santaRepo.getReferenceById(memberNo);
                if (referenceById.getRefID() != null) {
                    Santa santa = santaRepo.myGifter(referenceById.getRefID());
                    return new MyGifterResultDTO(santa.getFullName(), referenceById.getFullName());
                }
                return new MyGifterResultDTO(null, referenceById.getFullName());
            }
            throw new RuntimeException("Member Number Or Name is Incorrect Try Again");
        } else {
            throw new RuntimeException("Member Number Or Name is Incorrect Try Again");
        }
    }
}
