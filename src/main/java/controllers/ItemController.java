package controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Item;

@RestController
@RequestMapping("/api/employee")
public class ItemController {

	@GetMapping
	public Item find(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public List<Item> findAll() {
		return null;
	}

	@PutMapping
	public Item update(@PathVariable Long id, @RequestBody JSONObject employee) {
		return null;
	}

	@DeleteMapping
	public Item delete(@PathVariable Long id) {
		return null;
	}
}
