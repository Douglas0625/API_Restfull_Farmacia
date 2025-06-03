package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.ProveedorEntity;

import java.util.List;
import java.util.Optional;

public interface IProveedor {
    List<ProveedorEntity> findAll();

    ProveedorEntity save(ProveedorEntity proveedor);

    Optional<ProveedorEntity> findById(Long id);

    void deleteById(Long id);
}
