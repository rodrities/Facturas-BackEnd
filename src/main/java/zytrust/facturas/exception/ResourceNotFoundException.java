package zytrust.facturas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {super();}
    public ResourceNotFoundException(String message) { super(message); }
    public ResourceNotFoundException(String message, Throwable cause) { super(message, cause); }


    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Recurso %s no encontrado para %s con el valor de %s",
                resourceName, fieldName, fieldValue));

    }
}