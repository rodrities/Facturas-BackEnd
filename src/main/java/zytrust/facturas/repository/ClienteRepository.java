package zytrust.facturas.repository;

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
 * Esta clase representa el repositorio de Cliente que extiende de GenericRepository.
 *
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zytrust.facturas.dto.ClienteResponse;
import zytrust.facturas.dto.dto.ClienteDTO;
import zytrust.facturas.model.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value = "SELECT  c.nombre AS nombre,"
            +" c.apellido AS apellido, c.telefono AS numeroTelefono"
            +" FROM Cliente c GROUP BY c")
    List<ClienteDTO> findAllClienteDTO();

}
