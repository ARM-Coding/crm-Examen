package dws.altair.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dws.altair.examen.entities.Producto;

@Repository
/**
 * El repositorio que contiene los métodos derivados para comprobar si existen o buscar ciertas instancias dentro
 * de la tabla en base a las UK
 * @author ARM
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	boolean existsByCodigoSku(String codigoSku);
	
	Optional<Producto> findByCodigoSku(String codigo);
	
	void deleteByCodigoSku(String codigoSku);
	
}
