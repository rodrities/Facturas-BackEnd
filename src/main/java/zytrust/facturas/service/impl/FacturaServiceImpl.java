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
 * Esta interfaz representa la implementacion del servicio de Factura
 * que extiende de CrudServiceImpl .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.controller.FacturaController;
import zytrust.facturas.dto.FacturaDetailsResponse;
import zytrust.facturas.dto.FacturaRequest;
import zytrust.facturas.dto.FacturaResponse;
import zytrust.facturas.exception.ResourceNotFoundException;
import zytrust.facturas.model.Cliente;
import zytrust.facturas.model.Factura;
import zytrust.facturas.model.ProductoFactura;
import zytrust.facturas.repository.ClienteRepository;
import zytrust.facturas.repository.FacturaRepository;
import zytrust.facturas.service.ClienteService;
import zytrust.facturas.service.FacturaService;
import zytrust.facturas.service.ProductoFacturaService;
import zytrust.facturas.service.ProductoService;
import zytrust.facturas.util.FacturaConverter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoFacturaService productoFacturaService;

    @Autowired
    private FacturaConverter converter;

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(FacturaServiceImpl.class);

    @Override
    public Factura create(FacturaRequest facturaRequest)
            throws Exception {

        /*Cliente cliente = new Cliente();
        try {
            cliente = clienteRepository.getById(facturaRequest.getClienteId());
        }catch (Exception e) {
            logger.error("Cliente no encontrado");
            throw new ResourceNotFoundException( "Cliente", cliente.getId(), cliente );
        }*/

        Optional<Cliente> clienteOpt = clienteRepository.findById(facturaRequest.getClienteId());

        if (clienteOpt.isEmpty()) {
            logger.error("No se encontro el cliente con el id {}", facturaRequest.getClienteId());
            throw new ResourceNotFoundException("Cliente", "Facturas", facturaRequest.getClienteId());
        }

                /*.orElseThrow(
                () -> {
                    logger.info("Cliente no encontrado {}",
                            facturaRequest.getClienteId());
                    return new ResourceNotFoundException(
                            "Cliente no encontrado");
                });*/

        List<ProductoFactura> productos = new ArrayList<>();

        Factura factura = Factura
                .builder()
                .fechaEmision(LocalDate.now())
                .fechaVencimiento(facturaRequest.getFechaVencimiento())
                .subtotal(new BigDecimal(0.0))
                .total(new BigDecimal(0.0))
                .impuesto(new BigDecimal(0.0))
                .build();

    for (ProductoFactura producto: facturaRequest.getProductos()) {

        var productoTem = (
                productoService.getById(producto.getId()).orElseThrow(
                        () -> {
                            logger.info("Producto no encontrado {}",
                                    facturaRequest.getClienteId());
                            return new ResourceNotFoundException(
                                "Producto no encontrado");
                        }));

        var prodFacTem = new ProductoFactura();
        prodFacTem.setCantidad(producto.getCantidad());
        prodFacTem.setProducto(productoTem);

        productos.add(prodFacTem);

        productoFacturaService.create(prodFacTem);

        factura.setSubtotal(factura.getSubtotal()
                .add(productoTem.getPrecio().multiply(
                        new BigDecimal(prodFacTem.getCantidad()))));
    }

        factura.setImpuesto(factura.getSubtotal().multiply(new BigDecimal("0.18")));
        factura.setTotal(factura.getSubtotal().add(factura.getImpuesto()));

        factura.setCliente(clienteOpt.get());
        factura.setProductos(productos);
        logger.info("Factura creada con el id: {}", factura.getId());
        return facturaRepository.save(factura);
    }

    @Override
    public Factura update(Factura factura) throws Exception {
        return null;
    }

    @Override
    public List<FacturaResponse> getAll() throws Exception {
        return converter.convertFacturaToResponse(facturaRepository.findAll());
    }

    @Override
    public FacturaDetailsResponse getById(String id) throws Exception{

        return converter.convertFacturaDetailsToResponse(facturaRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontro Factura con id:" + id)));

    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public FacturaResponse cambiarStatus(String id, String status) throws Exception {

        var factura = facturaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Factura no encontrada"));

        factura.setStatus(status);


        facturaRepository.save(factura);

        return converter.convertFacturaToResponse(factura);
    }

    @Override
    public Factura actualizarTotales(Factura t) throws Exception {

        t.setSubtotal(new BigDecimal("0.00"));
        for (ProductoFactura producto: t.getProductos()) {
            t.setSubtotal(t.getSubtotal().add(producto.getProducto().getPrecio()
                    .multiply(new BigDecimal(producto.getCantidad()))));
        }

        // Se agregan los datos que no son requeridos ingresar por el cliente
        t.setImpuesto(t.getSubtotal().multiply(new BigDecimal("0.18")));
        t.setTotal(t.getSubtotal().add(t.getImpuesto()));
        // se agregan los objetos del cliente y productos

        return facturaRepository.save(t);
    }
}
