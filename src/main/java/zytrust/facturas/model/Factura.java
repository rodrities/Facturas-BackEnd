package zytrust.facturas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAC_ID")
    private Long id;

    @Column(name = "FAC_FEC_EMIS")
    private Date fechaEmision;
    @Column(name = "FAC_FEC_VENC")
    private Date fechaVencimiento;
    @Column(name = "FAC_TOTAL")
    private Double total;
    @Column(name = "FAC_SUBTOTAL")
    private Double subtotal;
    @Column(name = "FAC_IMPUESTO")
    private Double impuesto;
    @Column(name = "FAC_ESTATUS")
    private String status = "Ingresada";

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonIgnore
    Cliente cliente;


    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductoFactura> productos;

}
