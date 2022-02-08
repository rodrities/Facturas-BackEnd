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
 * Esta clase representa los campos de respuesta de una Factura.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import lombok.Data;
import zytrust.facturas.model.ProductoFactura;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class FacturaResponse {

    /* Atributos de respuesta al buscar una factura*/
    private String id;

    private LocalDate fechaEmision;

    private LocalDate fechaVencimiento;

    private BigDecimal total;

    //private List<ProductoFactura> productos;

    //private Cliente cliente;

    private BigDecimal subtotal;

    private BigDecimal impuesto;

    private String status;
}
