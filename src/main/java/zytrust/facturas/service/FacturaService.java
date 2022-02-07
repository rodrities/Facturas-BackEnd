package zytrust.facturas.service;

import org.springframework.stereotype.Service;
import zytrust.facturas.model.Factura;


public interface FacturaService extends CrudService<Factura, String> {
    Factura cambiarStatus(Factura t) throws Exception;
}
