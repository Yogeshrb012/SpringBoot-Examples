package com.learnSpring.p2.repository;

import com.learnSpring.p2.entity.Content;
import com.learnSpring.p2.entity.Physician;
import com.learnSpring.p2.projections.ContentPhysician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepo extends JpaRepository<Content,Integer> {
    @Query(nativeQuery = true,
            value = "SELECT P.NAME as Name, P.ID AS Id , C.RESPONSE AS Feedback " +
                    "FROM CONTENT C INNER JOIN DOCUMENTS D ON  C.doc_id = D.ID INNER JOIN" +
                    " PHYSICIAN P ON D.PHY_ID = P.ID WHERE P.ID = :physicianID")
    List<ContentPhysician> contentWithPhysicians(@Param("physicianID") int physicianID);
}
