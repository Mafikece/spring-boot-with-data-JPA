package com.mafik.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafik.main.Model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
