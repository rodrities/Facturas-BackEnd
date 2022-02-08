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

    @Override
    public Factura cambiarStatus(Factura t) throws Exception {
        return facturaRepository.save(t);
    }
}
