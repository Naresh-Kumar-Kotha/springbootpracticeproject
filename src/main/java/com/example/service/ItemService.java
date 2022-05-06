package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemRepository repo;

	public Item saveItem(Item item) {
		return repo.save(item);
	}

	public List<Item> saveItems(List<Item> items) {
		return repo.saveAll(items);
	}

	public List<Item> getItems() {
		return repo.findAll();
	}

	public Item getItemById(long id) {
		return repo.findById(id).get();
	}
	 
	public void deleteItem(long id) {
		repo.deleteById(id);
	}

	public Item updateItem(Item item) {
		Item ExistingItem = repo.findById(item.getId()).orElse(null);
		ExistingItem.setName(item.getName());
		ExistingItem.setQuantity(item.getQuantity());
		return repo.save(ExistingItem);
	}

}
