package zytrust.facturas.repository;

import org.springframework.stereotype.Repository;
import zytrust.facturas.model.Factura;

@Repository
public interface FacturaRepository extends GenericRepository<Factura, String> {

}
