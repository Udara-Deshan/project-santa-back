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
public interface SantaRepo extends JpaRepository<Santa, String> {

    @Query(value = "SELECT COUNT(*) from santa WHERE member_no NOT IN (SELECT refid FROM santa WHERE refid IS NOT NULL) AND member_no!=175", nativeQuery = true)
    int getCount(String id);
    @Query(value = "UPDATE santa set refid=?2 where member_no=?1",nativeQuery = true)
    boolean setSenta(String memberNo,String refId);

    @Query(value = "SELECT * FROM santa WHERE member_no NOT IN (SELECT refid FROM santa WHERE refid IS NOT NULL)" +
            " AND member_no!=?1 order by rand()",nativeQuery = true)
    List<Santa> getEligibleList(String memberNo);

    @Query(value = "select * from santa where member_no=?1",nativeQuery = true)
    Santa myGifter(String memberNo);

}
