package zytrust.facturas.service;

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
 * Esta interfaz representa el servicio de Factura que extiende de CrudService .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import zytrust.facturas.dto.FacturaDetailsResponse;
import zytrust.facturas.dto.FacturaRequest;
import zytrust.facturas.dto.FacturaResponse;
import zytrust.facturas.model.Factura;

import java.util.List;
import java.util.Optional;


public interface FacturaService {


    Factura create (FacturaRequest facturaRequest) throws Exception;


    Factura update (Factura factura) throws Exception;


    List<FacturaResponse> getAll() throws Exception;


    FacturaDetailsResponse getById(String id) throws Exception;

    void delete(String id) throws Exception;

    FacturaResponse cambiarStatus(String id, String status) throws Exception;
    Factura actualizarTotales(Factura t) throws Exception;
}
