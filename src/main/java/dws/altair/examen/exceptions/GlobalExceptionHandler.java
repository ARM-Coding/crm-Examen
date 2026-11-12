package dws.altair.examen.exceptions;

import java.time.Instant;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

//.forStatusAndDetail(HttpStatus.);
//problem.setTitle("");
//problem.setProperty("", Instant.);

/**
 * Clase que define las dos excepciones personalizadas (incompleto)
 * @author ARM
 */
public class GlobalExceptionHandler extends RuntimeException {
	
	public ProblemDetail ProductoNotFoundException(String msg) {
		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, msg);
		problem.setTitle("Producto no encontrado");
		problem.setProperty("El producto no se ha encontrado", Instant.now());
		
		return problem;
	}
	
}
