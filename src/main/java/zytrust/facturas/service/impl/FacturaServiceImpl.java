package zytrust.facturas.service.impl;
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
 * Esta interfaz representa la implementacion del servicio de Factura que extiende de CrudServiceImpl .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.exception.ResourceNotFoundException;
import zytrust.facturas.model.Factura;
import zytrust.facturas.model.ProductoFactura;
import zytrust.facturas.repository.FacturaRepository;
import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.service.FacturaService;
import zytrust.facturas.service.ProductoService;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class FacturaServiceImpl extends CrudServiceImpl<Factura, String> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    protected GenericRepository<Factura, String> getRepository() {
        return facturaRepository;
    }

    @Override
    public Factura cambiarStatus(Factura t) throws Exception {
        return facturaRepository.save(t);
    }

    @Override
    public Factura actualizarTotales(Factura t) throws Exception {

        t.setSubtotal(new BigDecimal("0.00"));
        for (ProductoFactura producto: t.getProductos()) {
            t.setSubtotal(t.getSubtotal().add(producto.getProducto().getPrecio().multiply(new BigDecimal(producto.getCantidad()))));
        }

        // Se agregan los datos que no son requeridos ingresar por el cliente
        t.setImpuesto(t.getSubtotal().multiply(new BigDecimal("0.18")));
        t.setTotal(t.getSubtotal().add(t.getImpuesto()));
        // se agregan los objetos del cliente y productos

        return facturaRepository.save(t);
    }
}
