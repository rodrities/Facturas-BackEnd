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
 * Esta interfaz representa la implementacion del servicio de Producto
 * que extiende de CrudServiceImpl .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.dto.ClienteRequest;
import zytrust.facturas.dto.ClienteResponse;
import zytrust.facturas.dto.dto.ClienteDTO;
import zytrust.facturas.exception.ResourceNotFoundException;
import zytrust.facturas.model.Cliente;
import zytrust.facturas.repository.ClienteRepository;
import zytrust.facturas.service.ClienteService;
import zytrust.facturas.util.ClienteConverter;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteConverter converter;

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(FacturaServiceImpl.class);

    @Override
    public Cliente create(ClienteRequest clienteRequest) throws Exception {

        var tem = converter.convertClienteToEntity(clienteRequest);
        return clienteRepository.save(tem);

    }

    @Override
    public Cliente update(Cliente cliente) throws Exception {
        return null;
    }

    @Override
    public List<ClienteResponse> getAll(){
        return converter.convertClienteToResponse(clienteRepository.findAll());
    }

    @Override
    public ClienteResponse getById(String id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isEmpty()) {
            logger.info("Cliente no encontrado con el id {}", id);
            throw new ResourceNotFoundException("No se encontró el cliente");
        }

        return converter.convertClienteToResponse(cliente.get());
    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public List<ClienteDTO> getAllDTO() {
        return clienteRepository.findAllClienteDTO();
    }

    @Override
    public ClienteResponse getByIdDTO(String id) {
        return null;
    }
}
