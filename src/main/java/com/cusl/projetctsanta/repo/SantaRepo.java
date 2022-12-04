package com.cusl.projetctsanta.repo;

import com.cusl.projetctsanta.entity.Santa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 12/2/2022
 **/
@Repository
public interface SantaRepo extends JpaRepository<Santa, Integer> {

    @Query(value = "SELECT COUNT(*) from santa where refID IS NULL and id!=?1", nativeQuery = true)
    int getCount(int id);
    @Query(value = "UPDATE santa set refID=?2 where email=?1",nativeQuery = true)
    boolean setSenta(String email,int refId);

    @Query(value = "SELECT * from santa where refID IS NULL and id!=?1 order by rand()",nativeQuery = true)
    List<Santa> getEligibleList(int id);
}
