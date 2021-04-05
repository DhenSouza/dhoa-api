package com.hardtech.doabookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardtech.doabookapi.models.Categorias;
import com.hardtech.doabookapi.repositories.CategoriasRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/categorias")
public class CategoriasController {

	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable long id){
		return repository.findById(id).map(obj -> ResponseEntity.ok(obj)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categorias>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Categorias> post (@RequestBody Categorias categorias){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
	}
	
	@PutMapping
	public ResponseEntity<Categorias> put (@RequestBody Categorias categorias){
		return ResponseEntity.ok(repository.save(categorias));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
