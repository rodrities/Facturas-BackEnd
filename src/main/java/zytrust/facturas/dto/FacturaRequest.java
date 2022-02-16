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
 * Esta clase representa los campos que se requieren para crear una Factura.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import lombok.Data;
import zytrust.facturas.model.ProductoFactura;

import java.time.LocalDate;
import java.util.List;

@Data
public class FacturaRequest {

    private String clienteId;

    /** Lista de produtos requeridos para la creacion de factura*/
    private List<ProductoFactura> productos;

    /** Fecha de vencimiento requerida para la creacion de factura*/
    private LocalDate fechaVencimiento;
}
