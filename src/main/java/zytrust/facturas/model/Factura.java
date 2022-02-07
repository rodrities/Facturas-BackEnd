package zytrust.facturas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FAC_FACTURAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.ALWAYS)
public class Factura {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "FAC_ID")
    private String id;

    @Column(name = "FAC_FEC_EMIS")
    private LocalDate fechaEmision;

    @Column(name = "FAC_FEC_VENC")
    private LocalDate fechaVencimiento;

    @Column(name = "FAC_TOTAL")
    private BigDecimal total ;

    @Column(name = "FAC_SUBTOTAL")
    private BigDecimal subtotal = new BigDecimal("0.00");

    @Column(name = "FAC_IMPUESTO")
    private BigDecimal impuesto;

    @Column(name = "FAC_ESTATUS")
    private String status = "Ingresada";

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIE_ID", nullable = false)
    @JsonIgnore
    Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductoFactura> productos;

}
