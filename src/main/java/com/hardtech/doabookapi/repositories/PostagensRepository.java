package com.hardtech.doabookapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardtech.doabookapi.models.Postagens;

public interface PostagensRepository extends JpaRepository<Postagens, Long> {
	//public List<Postagens> findAllByTituloContainingIgnoreCase(String titulo);

	public List<Postagens> findAllByTipoPostagemContainingIgnoreCase(String tipoPostagem );
	public List<Postagens> findAllByCategoriaId(Long idCategoria);
	public List<Postagens> findAllByTextoContainingIgnoreCase(String texto);
	
	//@Query(value = "SELECT * FROM dhoa.tb_postagens WHERE usuario_id = :idUsuario AND categoria_id = :idCategoria", nativeQuery = true )
	//public List<Postagens> findAllByUsuarioCategoria(@Param("idUsuario") Long idUsuario, @Param("idCategoria") Long idCategoria);
	
	@Query(value = "SELECT * FROM heroku_3e709c48315fce6.tb_postagens WHERE usuario_id = :idUsuario ", nativeQuery = true )
	public List<Postagens> findAllByUsuario(@Param("idUsuario") Long idUsuario);
	
	public List<Postagens> findAllByUsuarioIdAndCategoriaId(Long idUsuario, Long idCategoria);
}
