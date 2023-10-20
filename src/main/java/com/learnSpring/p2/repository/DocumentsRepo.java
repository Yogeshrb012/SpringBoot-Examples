package com.learnSpring.p2.repository;

import com.learnSpring.p2.entity.Document;
import com.learnSpring.p2.projections.ContentDocumentPhysician;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepo extends JpaRepository<Document, Integer> {
    @Query(nativeQuery = true,
    value = "SELECT P.ID as ID,P.Name AS Name, D.ID AS DocID, C.Question as Question, C.Response as Response " +
            "from Content C JOIN Documents D on D.ID = C.DOC_ID " +
            "JOIN Physician P on D.PHY_ID = P.ID where active_Flag = :active_Flag")
    List<ContentDocumentPhysician> getDetailsFromActivePhysician(@Param("active_Flag") String active_Flag);
}
