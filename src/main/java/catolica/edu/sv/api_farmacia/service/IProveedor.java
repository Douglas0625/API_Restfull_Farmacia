package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.ProveedorEntity;

import java.util.List;

public interface IProveedor {

    List<ProveedorEntity> findAll();
    ProveedorEntity save(ProveedorEntity proveedor);
}
