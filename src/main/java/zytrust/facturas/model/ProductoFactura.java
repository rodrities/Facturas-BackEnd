package zytrust.facturas.model;

/*
 * @(#)Cliente.java
 *
 * Copyright 2022 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un detalle de la factura y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "FAC_PROD_FACTURA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFactura {

    /** Identificador del productoFactura*/
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PFAC_ID")
    private String id;

    /** Cantidad del productoFactura*/
    @Column(name = "PFAC_CANTIDAD")
    private Integer cantidad;

    /** Factura del productoFactura*/
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Factura factura;

    /** Producto del productoFactura*/
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Producto producto;
}
