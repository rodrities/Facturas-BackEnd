package zytrust.facturas.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FacturaRequest {

    private Date fechaEmision;
    private Date fechaVencimiento;
    //private List<Product> products;
    //private cliente
}
