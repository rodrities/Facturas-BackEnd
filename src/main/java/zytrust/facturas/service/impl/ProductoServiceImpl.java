package zytrust.facturas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.model.Factura;
import zytrust.facturas.model.Producto;
import zytrust.facturas.repository.FacturaRepository;
import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.repository.ProductoRepository;
import zytrust.facturas.service.FacturaService;
import zytrust.facturas.service.ProductoService;

@Service
public class ProductoServiceImpl extends CrudServiceImpl<Producto, String> implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    protected GenericRepository<Producto, String> getRepository() {
        return productoRepository;
    }
}
