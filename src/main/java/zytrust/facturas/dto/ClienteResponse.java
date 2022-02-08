package zytrust.facturas.dto;
/*
 * @(#)Cliente.java
 *
 * Copyright 2022 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa los campos de respuesta para un Cliente.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import lombok.Data;

@Data
public class ClienteResponse {

    /* Atributos de respuesta al buscar un cliente */
    private String id;

    private String nombre;

    private String apellido;

    private String direccion;

    private String telefono;

    private String tipoDocumento;

    private String numDocumento;
}
