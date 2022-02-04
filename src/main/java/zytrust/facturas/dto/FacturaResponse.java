package zytrust.facturas.dto;

import lombok.Data;
import zytrust.facturas.model.Cliente;
import zytrust.facturas.model.ProductoFactura;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
public class FacturaResponse {

    private String id;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Double total;
    private List<ProductoFactura> productos;
    private Cliente cliente;

    private Double subtotal;

    private Double impuesto;

    private String status = "Ingresada";
}
