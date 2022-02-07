package zytrust.facturas.repository;

import org.springframework.stereotype.Repository;

import zytrust.facturas.model.ProductoFactura;

@Repository
public interface ProductoFacturaRepository extends GenericRepository<ProductoFactura, String>{
}
