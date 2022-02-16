package zytrust.facturas.service;

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
 * Esta interfaz representa el servicio de Cliente que extiende de CrudService .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import zytrust.facturas.dto.*;
import zytrust.facturas.dto.dto.ClienteDTO;
import zytrust.facturas.model.Cliente;

import java.util.List;

public interface ClienteService{

    Cliente create (ClienteRequest clienteRequest) throws Exception;


    Cliente update (Cliente cliente) throws Exception;


    List<ClienteResponse> getAll();


    ClienteResponse getById(String id);

    void delete(String id) throws Exception;

    List<ClienteDTO> getAllDTO();


    ClienteResponse getByIdDTO(String id);

}
