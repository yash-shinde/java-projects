package com.prog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.Entity.Pateint_entity;

@Repository
public interface PatRepo extends JpaRepository<Pateint_entity, Integer> {

}
