package zytrust.facturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zytrust.facturas.dto.ClienteRequest;
import zytrust.facturas.dto.ClienteResponse;
import zytrust.facturas.dto.ProductoRequest;
import zytrust.facturas.dto.ProductoResponse;
import zytrust.facturas.service.ClienteService;
import zytrust.facturas.service.ProductoService;
import zytrust.facturas.util.ClienteConverter;
import zytrust.facturas.util.ProductoConverter;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @Autowired
    private ProductoConverter converter;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAll() throws Exception{
        var productos = productoService.getAll();
        return new ResponseEntity<>(converter.convertProductoToResponse(productos), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> createProducto(@Valid @RequestBody ProductoRequest request
    ) throws Exception{

        var tem = converter.convertProductoToEntity(request);
        var producto = productoService.create(tem);
        return new ResponseEntity<>(converter.convertProductoToResponse(producto), HttpStatus.ACCEPTED);
    }
}
