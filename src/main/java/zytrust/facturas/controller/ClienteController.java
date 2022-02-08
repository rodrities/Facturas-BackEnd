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
 * Esta clase representa el controllador Cliente que interactua con el cliente .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zytrust.facturas.dto.ClienteRequest;
import zytrust.facturas.dto.ClienteResponse;
import zytrust.facturas.service.ClienteService;
import zytrust.facturas.util.ClienteConverter;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @Autowired
    private ClienteConverter converter;

     /**
     * @return      el objeto cliente con el status Http200
      */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll() throws Exception{
        var clientes = clienteService.getAll();
        return new ResponseEntity<>(converter.convertClienteToResponse(clientes), HttpStatus.OK);
    }

    /**
     * @params  request el objeto cliente en json que se convertira en el objeto a crear
     * @return      el objeto cliente con el status Http200

     */
    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@Valid @RequestBody ClienteRequest request
    ) throws Exception{

        var tem = converter.convertClienteToEntity(request);
        var cliente = clienteService.create(tem);
        return new ResponseEntity<>(converter.convertClienteToResponse(cliente), HttpStatus.ACCEPTED);
    }
}
