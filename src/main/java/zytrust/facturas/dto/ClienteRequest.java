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
 * Esta clase representa los campos que se requieren para crear un Cliente.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import lombok.Data;

@Data
public class ClienteRequest {
    /** Nombre requerido para la creacion de un Cliente */
    private String nombre;

    /** Apellido requerido para la creacion de un Cliente */
    private String apellido;

    /** Direccion requerido para la creacion de un Cliente */
    private String direccion;

    /** Telefono requerido para la creacion de un Cliente */
    private String telefono;

    /** Tipo de documento requerido para la creacion de un Cliente */
    private String tipoDocumento;

    /** Numero de documento requerido para la creacion de un Cliente */
    private String numDocumento;
}
