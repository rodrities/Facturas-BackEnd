package zytrust.facturas.repository;

import org.springframework.stereotype.Repository;
import zytrust.facturas.model.Factura;
import zytrust.facturas.model.Producto;

@Repository
public interface ProductoRepository  extends GenericRepository<Producto, Long>{
}
