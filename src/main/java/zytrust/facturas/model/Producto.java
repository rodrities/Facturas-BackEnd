package zytrust.facturas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PROD_ID")
    private String id;

    @Column(name = "PROD_NOMBRE")
    private String nombre;

    @Column(name = "PROD_STOCK")
    private Integer stock;

    @Column(name ="PROD_PRECIO")
    private BigDecimal precio;

    @Column(name = "PROD_DESCRIPCION")
    private String descripcion;

}
