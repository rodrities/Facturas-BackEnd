package zytrust.facturas.dto;

import lombok.Data;
import zytrust.facturas.model.ProductoFactura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class FacturaDetailsResponse {

    private String id;

    private LocalDate fechaEmision;

    private LocalDate fechaVencimiento;

    private BigDecimal total;

    private List<ProductoFactura> productos;

    //private Cliente cliente;

    private BigDecimal subtotal;

    private BigDecimal impuesto;

    private String status;
}
