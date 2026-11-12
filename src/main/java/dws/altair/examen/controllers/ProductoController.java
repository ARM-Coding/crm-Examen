package dws.altair.examen.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dws.altair.examen.dtos.ProductoRequestDto;
import dws.altair.examen.dtos.ProductoResponseDto;
import dws.altair.examen.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
/**
 * Controlador para los endpoints de la API, con funcionalidad para obtener todos los productos, crear nuevos productos,
 * actualizar en base al SKU, y borrar en base al SKU
 * @author ARM
 */
public class ProductoController {
	
	private final ProductoService productoService;
	
	/**
	 * Inyectamos la clase del Servicio de Producto mediante el uso de un constructor
	 * @param productoService
	 */
	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	@GetMapping
	/**
	 * Endpoint para obtener todos los productos de la tabla
	 * @return
	 */
	public ResponseEntity <List<ProductoResponseDto>> obtenerAll() {
		return ResponseEntity.ok(productoService.obtenerAll());
	}
	
	/**
	 * Endpoint para crear un nuevo producto en la tabla de Productos
	 * @param requestDto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ProductoRequestDto> create(@RequestBody ProductoRequestDto requestDto) {
		ProductoResponseDto newProduct = productoService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(requestDto);
	}
	
	/**
	 * Endpoint para actualizar un producto pre-existente de la tabla Producto en base a un código SKU concrete,
	 * modificando sus campos con el contenido de la Request
	 * @param codigoSku
	 * @param requestDto
	 * @return
	 */
	@PutMapping("/sku/{codigoSku}")
	public ResponseEntity<ProductoResponseDto> updateBySku(@PathVariable String codigoSku, 
			@RequestBody ProductoRequestDto requestDto) {
		ProductoResponseDto updatedProduct = productoService.update(codigoSku, requestDto);
		return ResponseEntity.ok(productoService.update(codigoSku, requestDto));
	}
	
	/**
	 * Endpoint para eliminar un producto de la tabla de Productos en base a un código SKU concreto
	 * @param codigoSku
	 * @return
	 */
	@DeleteMapping("/sku/{codigoSku}")
	public ResponseEntity<ProductoResponseDto> deleteBySku(@PathVariable String codigoSku) {
		productoService.delete(codigoSku);
		return ResponseEntity.noContent().build();
	}
	
}
