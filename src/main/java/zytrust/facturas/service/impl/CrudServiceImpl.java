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
 * Esta interfaz representa la implementacion de CrudService .
 * @author Rodrigo Ticona
 * @version 1.0.0, 04/02/2022
 */
import zytrust.facturas.repository.GenericRepository;
import zytrust.facturas.service.CrudService;
import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    protected abstract GenericRepository<T,ID> getRepository();

    /*
    * @params  t   El objeto de tipo T que se creará
    * @return      el repositry con la funcion save, para guardar el objeto
    */
    @Override
    public T create(T t) throws Exception {
        return getRepository().save(t);
    }

    /*
     * @params  t   El objeto de tipo T que se actualizará
     * @return      el repositry con la funcion save, para guardar el objeto
     */
    @Override
    public T update(T t) throws Exception {
        return getRepository().save(t);
    }

    /*
     * @return      el repositry con la funcion de encontrar todos los objetos
     */
    @Override
    public List<T> getAll() throws Exception {
        return getRepository().findAll();
    }

    /*
     * @params  id  el identificador del objeto
     * @return      el repositry con la funcion de encontrar por id
     */
    @Override
    public Optional<T> getById(ID id) throws Exception {
        return getRepository().findById(id);
    }

    /*
     * @params  id  El identificador del obajeto que se eliminará
     * @return      el repositry con la funcion del eliminar por id
     */
    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
