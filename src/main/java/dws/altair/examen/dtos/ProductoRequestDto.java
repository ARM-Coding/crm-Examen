package dws.altair.examen.dtos;

import java.time.LocalDate;

/**
 * La request que se enviará desde la vista Web, con todos los campos que habría que especificar
 * @author ARM
 */
public record ProductoRequestDto(Long idProduct,
								String codigoSku,
								String nombre,
								String descripcion,
								Long precio,
								int stock,
								LocalDate fechaAlta) {

}
