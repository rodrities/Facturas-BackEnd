package zytrust.facturas.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoResponse {

    private String id;

    private String nombre;

    private Integer stock;

    private BigDecimal precio;

    private String descripcion;
}
