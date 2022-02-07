package zytrust.facturas.repository;

import org.springframework.stereotype.Repository;
import zytrust.facturas.model.Cliente;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente, String>{
}
