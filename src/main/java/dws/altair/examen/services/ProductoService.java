package dws.altair.examen.services;

import java.util.List;

import dws.altair.examen.dtos.ProductoRequestDto;
import dws.altair.examen.dtos.ProductoResponseDto;

/**
 * Interfaz de Servicio de Producto que define todos los métodos del CRUD necesarios para la interacción con los
 * datos de la tabla, incluyendo los obtención, creación, modificación y borrado de los mismos
 * @author ARM
 */
public interface ProductoService {
	
	/**
	 * Método para obtener una lista de todos los productos
	 * @return
	 */
	public List<ProductoResponseDto> obtenerAll();
	
	/**
	 * Método para crear un nuevo producto en base a los datos introducidos en la Request
	 * @param requestDto
	 * @return
	 */
	public ProductoResponseDto create(ProductoRequestDto requestDto);
	
	/**
	 * Método para actualizar/modificar los datos de un producto específico en base a la ID, utilizando los
	 * datos rellenados en la Request
	 * @param idProducto
	 * @param requestDto
	 * @return
	 */
	public ProductoResponseDto update(String codigoSku, ProductoRequestDto requestDto);
	
	
	/**
	 * Método para borrar un producto específico de la tabla en base a la ID proporcionada
	 * @param idProducto
	 */
	public void delete(String codigoSku);
	
}
