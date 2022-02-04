package zytrust.facturas.util;

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
        return productos.stream().map(producto -> modelMapper.map(producto, ProductoResponse.class)).collect(Collectors.toList());
    }
}
