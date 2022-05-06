package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Item;
import com.example.service.ItemService;
@Configuration
@RestController
public class ItemController {

	@Autowired

	private ItemService service;

	@GetMapping(value = "/")
	public String HomePage() {

		return "index";
	}

	@GetMapping(value = "/additem")
	public String itemfrm(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "additem";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("item") Item item) {
		service.saveItem(item);
		return "redirect:/";
	}

	@PostMapping("/additems")
	public List<Item> addItem(@RequestBody List<Item> items) {
		return service.saveItems(items);
	}

	@GetMapping("/items")
	public List<Item> findAllItems() {
		return service.getItems();
	}

	@GetMapping("/items/{id}")
	public Item findItemById(@PathVariable int id) {
		return service.getItemById(id);
	}

	@PutMapping("/update")
	public Item updateItem(@RequestBody Item item) {
		return service.updateItem(item);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteItem(@PathVariable int id) {
		service.deleteItem(id);
	}
}
