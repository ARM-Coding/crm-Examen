package dws.altair.examen.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto", schema = "crmExamen")
/**
 * Entidad Producto del modelo virtual, con los atributos
 * - idProduct
 * - codigoSku
 * - nombre
 * - descripcion
 * - precio
 * - stock
 * 
 * Posee los constructores vacíon tanto como uno custom, a la vez que los getters & setters
 * @author ARM
 */
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long idProduct;
	
	@Column(name = "codigo_sku", unique = true, nullable = false, length = 10)
	private String codigoSku;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 255)
	private String descripcion;
	
	@Column(name = "precio", nullable = false)
	private Long precio;
	
	@Column(name = "stock", nullable = false)
	private int stock;
	
	@Column(name = "fecha_alta", nullable = false)
	private LocalDate fechaAlta;
	
	// Constructor custom y vacío
	
	public Producto() {};
	
	public Producto(Long idProduct, String codigoSku, String nombre, String descripcion, Long precio, int stock,
			LocalDate fechaAlta) {
		super();
		this.idProduct = idProduct;
		this.codigoSku = codigoSku;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
	}
	
	// Getters & Setters
	
	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getCodigoSku() {
		return codigoSku;
	}

	public void setCodigoSku(String codigoSku) {
		this.codigoSku = codigoSku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
}
