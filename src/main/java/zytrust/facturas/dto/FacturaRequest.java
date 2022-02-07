package zytrust.facturas.dto;

import lombok.Data;

import zytrust.facturas.model.ProductoFactura;

import java.util.List;

@Data
public class FacturaRequest {

    private List<ProductoFactura> productos;

}
