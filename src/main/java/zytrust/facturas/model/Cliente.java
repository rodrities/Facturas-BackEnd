package zytrust.facturas.model;

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

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CLIE_ID")
    private String id;

    @Column(name = "CLIE_NOMBRE")
    private String nombre;

    @Column(name = "CLIE_APELLIDO")
    private String apellido;

    @Column(name = "CLIE_DIRECCION")
    private String direccion;

    @Column(name = "CLIE_TELEFONO")
    private String telefono;

    @Column(name = "CLIE_TIP_DOC")
    private String tipoDocumento;

    @Column(name = "CLIE_NUM_DOC")
    private String numDocumento;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Column(name = "CLIE_FACTURAS")
    private List<Factura> facturas;
}
