package zytrust.facturas.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FacturaResponse {

    private String id;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Double total;
    //private
    //private List
    //private cliente
}
