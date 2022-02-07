package zytrust.facturas.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ClienteResponse {

    private String id;

    private String nombre;

    private String apellido;

    private String direccion;

    private String telefono;

    private String tipoDocumento;

    private String numDocumento;
}
