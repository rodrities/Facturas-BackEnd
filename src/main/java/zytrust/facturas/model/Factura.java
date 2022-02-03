package zytrust.facturas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaEmision;
    private Date fechaVencimiento;
    private Double total;
    private String status = "Ingresada";

    //private clienteId
    //private products
}
