package zytrust.facturas.util;

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
 * Esta clase representa la clase que convierte el objeto Producto.
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zytrust.facturas.dto.ProductoRequest;
import zytrust.facturas.dto.ProductoResponse;
import zytrust.facturas.model.Producto;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Producto convertProductoToEntity(ProductoRequest request){
        return modelMapper.map(request, Producto.class);
    }

    public ProductoResponse convertProductoToResponse(Producto producto){
        return modelMapper.map(producto, ProductoResponse.class);
    }

    public List<ProductoResponse> convertProductoToResponse(List<Producto> productos) {
        return productos.stream().map(producto -> modelMapper.map(producto, ProductoResponse.class))
                .collect(Collectors.toList());
    }
}
