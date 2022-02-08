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
 * Esta clase representa los campos que se requieren para crear un Producto.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoRequest {

    /** Nombre requerido para crear un producto */
    private String nombre;

    /** Stock requerido para crear un producto */
    private Integer stock;

    /** Precio requerido para crear un producto */
    private BigDecimal precio;

    /** Descripcion requerido para crear un producto */
    private String descripcion;
}
