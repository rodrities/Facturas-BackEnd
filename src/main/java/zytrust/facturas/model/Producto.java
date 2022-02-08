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
 * Esta clase representa a un producto y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
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

    /** Identificador del producto */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PROD_ID")
    private String id;

    /** Nombre del producto */
    @Column(name = "PROD_NOMBRE")
    private String nombre;

    /** Stock del producto*/
    @Column(name = "PROD_STOCK")
    private Integer stock;

    /** Precio del producto */
    @Column(name ="PROD_PRECIO")
    private BigDecimal precio;

    /** Descripcion del producto */
    @Column(name = "PROD_DESCRIPCION")
    private String descripcion;

}
