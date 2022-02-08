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
 * Esta clase representa la clase que convierte el objeto Cliente.
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zytrust.facturas.dto.ClienteRequest;
import zytrust.facturas.dto.ClienteResponse;
import zytrust.facturas.model.Cliente;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente convertClienteToEntity(ClienteRequest request){
        return modelMapper.map(request, Cliente.class);
    }

    public ClienteResponse convertClienteToResponse(Cliente cliente){
        return modelMapper.map(cliente, ClienteResponse.class);
    }

    public List<ClienteResponse> convertClienteToResponse(List<Cliente> clientes) {
        return clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteResponse.class))
                .collect(Collectors.toList());
    }
}
