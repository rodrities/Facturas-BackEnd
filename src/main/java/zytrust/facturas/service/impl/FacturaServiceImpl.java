package zytrust.facturas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.model.Factura;
import zytrust.facturas.repository.FacturaRepository;
import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.service.FacturaService;

@Service
public class FacturaServiceImpl extends CrudServiceImpl<Factura, String> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    protected GenericRepository<Factura, String> getRepository() {
        return facturaRepository;
    }
}
