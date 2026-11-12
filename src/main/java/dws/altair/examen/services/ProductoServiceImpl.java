package dws.altair.examen.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.altair.examen.dtos.ProductoRequestDto;
import dws.altair.examen.dtos.ProductoResponseDto;
import dws.altair.examen.entities.Producto;
import dws.altair.examen.repositories.ProductoRepository;

@Service
/**
 * Clase que implementa toda la logística de los métodos del CRUD predefinidos en la interfaz ProductoService
 * @author ARM
 */
public class ProductoServiceImpl implements ProductoService {
	
	/**
	 * Método mapToResponseDto que convierte el resultado de los métodos CRUD de una entidad a un Response que
	 * puede ser mostrado y enviado de vuelta al cliente en un formatio JSON
	 * @param producto
	 * @return
	 */
	private ProductoResponseDto mapToResponseDto(Producto producto) {
		return new ProductoResponseDto(
				producto.getIdProduct(),
				producto.getCodigoSku(),
				producto.getNombre(),
				producto.getDescripcion(),
				producto.getPrecio(),
				producto.getStock(),
				producto.getFechaAlta()
				);
	}
	
	private ProductoRepository productoRepository;
	
	/**
	 * Inyección del repositorio mediante el use de un constructor
	 * @param productoRepository
	 */
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoResponseDto> obtenerAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll()
		.stream()
		.map(this::mapToResponseDto)
		.toList();
	}

	@Override
	@Transactional
	public ProductoResponseDto create(ProductoRequestDto requestDto) {
		// TODO Auto-generated method stub
		if (productoRepository.existsByCodigoSku(requestDto.codigoSku())) {
			throw new Error();
		}
		
		Producto newProducto = new Producto(
				requestDto.idProduct(),
				requestDto.codigoSku(),
				requestDto.nombre(),
				requestDto.descripcion(),
				requestDto.precio(),
				requestDto.stock(),
				LocalDate.now()
				);
		
		Producto saved = productoRepository.save(newProducto);
		
		return mapToResponseDto(saved);
	}

	@Override
	@Transactional
	public ProductoResponseDto update(String codigoSku, ProductoRequestDto requestDto) {
		// TODO Auto-generated method stub
		if (!productoRepository.existsByCodigoSku(codigoSku)) {
			throw new Error();
		}
		
		Producto productoFound = productoRepository.findByCodigoSku(codigoSku).orElseThrow();
		
		productoFound.setCodigoSku(requestDto.codigoSku());
		productoFound.setNombre(requestDto.nombre());
		productoFound.setDescripcion(requestDto.descripcion());
		productoFound.setPrecio(requestDto.precio());
		productoFound.setStock(requestDto.stock());
		
		Producto updated = productoRepository.save(productoFound);
		
		return mapToResponseDto(updated);
	}

	@Override
	@Transactional
	public void delete(String codigoSku) {
		// TODO Auto-generated method stub
		if (!productoRepository.existsByCodigoSku(codigoSku)) {
			throw new Error();
		}
		
		productoRepository.deleteByCodigoSku(codigoSku);
		
	}

}
