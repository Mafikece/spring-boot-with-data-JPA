package com.mafik.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mafik.main.model.Programmer;
@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer>{

}
