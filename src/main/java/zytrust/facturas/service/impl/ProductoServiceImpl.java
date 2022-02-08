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
 * Esta interfaz representa la implementacion del servicio de Producto que extiende de CrudServiceImpl .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.model.Producto;
import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.repository.ProductoRepository;
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
