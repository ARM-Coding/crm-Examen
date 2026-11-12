package dws.altair.examen.dtos;

import java.time.LocalDate;

/**
 * La respuesta que recibirá el cliente desde la API junto con los campos que irán consigo
 * @author ARM
 */
public record ProductoResponseDto(Long idProduct,
								String codigoSku,
								String nombre,
								String descripcion,
								Long precio,
								int stock,
								LocalDate fechaAlta) {

}
