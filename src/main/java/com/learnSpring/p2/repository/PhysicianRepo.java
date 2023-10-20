package com.learnSpring.p2.repository;

import com.learnSpring.p2.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhysicianRepo extends JpaRepository<Physician,Integer> {




}
