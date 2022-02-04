package zytrust.facturas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zytrust.facturas.model.Cliente;

import zytrust.facturas.repository.ClienteRepository;

import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.service.ClienteService;

@Service
public class ClienteServiceImpl extends CrudServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected GenericRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }
}
