package zytrust.facturas.controller;

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
 * Esta clase representa el controllador Producto que interactua con el cliente .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zytrust.facturas.dto.ProductoRequest;
import zytrust.facturas.dto.ProductoResponse;
import zytrust.facturas.service.ProductoService;
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

    /**
     * @return   el objeto producto con el status Http200
     * */
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAll() throws Exception{
        var productos = productoService.getAll();
        return new ResponseEntity<>(converter.convertProductoToResponse(productos), HttpStatus.OK);
    }

    /**
     * @params  request el objeto producto en json que se convertira en el objeto a crear
     * @return      el objeto producto con el status Http200
     */
    @PostMapping
    public ResponseEntity<ProductoResponse> createProducto(@Valid @RequestBody ProductoRequest request
    ) throws Exception{

        var tem = converter.convertProductoToEntity(request);
        var producto = productoService.create(tem);
        return new ResponseEntity<>(converter.convertProductoToResponse(producto), HttpStatus.ACCEPTED);
    }
}
