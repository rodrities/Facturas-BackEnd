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


import org.springframework.stereotype.Repository;
import zytrust.facturas.model.Cliente;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente, String>{
}
