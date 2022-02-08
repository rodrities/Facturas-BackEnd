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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FAC_CLIENTES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    /** Identificador del cliente */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CLIE_ID")
    private String id;

    /** Nombre del cliente */
    @Column(name = "CLIE_NOMBRE")
    private String nombre;

    /** Apellido del cliente */
    @Column(name = "CLIE_APELLIDO")
    private String apellido;

    /** Direccion del cliente */
    @Column(name = "CLIE_DIRECCION")
    private String direccion;

    /** Numero de telefono del cliente */
    @Column(name = "CLIE_TELEFONO")
    private String telefono;

    /** Tipo de documento del cliente */
    @Column(name = "CLIE_TIP_DOC")
    private String tipoDocumento;

    /** Num de documento del cliente */
    @Column(name = "CLIE_NUM_DOC")
    private String numDocumento;

    /** Facturas del cliente */
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Column(name = "CLIE_FACTURAS")
    private List<Factura> facturas;
}
