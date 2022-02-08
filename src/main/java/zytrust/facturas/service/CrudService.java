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
 * Esta interfaz representa el layout de las que los demas serviocios extenderan.
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import java.util.List;
import java.util.Optional;

public interface CrudService <T, ID> {

    T create (T t) throws Exception;

    T update (T t) throws Exception;

    List<T> getAll() throws Exception;

    Optional<T> getById(ID id) throws Exception;

    void delete(ID id) throws Exception;
}
