package zytrust.facturas.controller;

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

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll() throws Exception{
        var clientes = clienteService.getAll();
        return new ResponseEntity<>(converter.convertClienteToResponse(clientes), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@Valid @RequestBody ClienteRequest request
    ) throws Exception{

        var tem = converter.convertClienteToEntity(request);
        var cliente = clienteService.create(tem);
        return new ResponseEntity<>(converter.convertClienteToResponse(cliente), HttpStatus.ACCEPTED);
    }
}
