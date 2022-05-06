package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bean.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findByName(String name);

}
