package zytrust.facturas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zytrust.facturas.model.ProductoFactura;

import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.repository.ProductoFacturaRepository;

import zytrust.facturas.service.ProductoFacturaService;

@Service
public class ProductoFacturaServiceImpl extends CrudServiceImpl<ProductoFactura, String> implements ProductoFacturaService {

    @Autowired
    private ProductoFacturaRepository productoFacturaRepository;

    @Override
    protected GenericRepository<ProductoFactura, String> getRepository() {
        return productoFacturaRepository;
    }
}
