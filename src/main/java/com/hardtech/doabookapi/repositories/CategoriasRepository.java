package com.hardtech.doabookapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardtech.doabookapi.models.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	public List<Categorias> findAllByNomeContainingIgnoreCase(String nome);
}
