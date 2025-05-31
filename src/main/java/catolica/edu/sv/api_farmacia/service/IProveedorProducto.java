package catolica.edu.sv.api_farmacia.service;


import catolica.edu.sv.api_farmacia.entities.ProveedorProductoEntity;
import catolica.edu.sv.api_farmacia.entities.ProveedorProductoId;
import catolica.edu.sv.api_farmacia.entities.VentaDetalleEntity;
import catolica.edu.sv.api_farmacia.entities.VentaDetalleId;

import java.util.List;
import java.util.Optional;

public interface IProveedorProducto {

    List<ProveedorProductoEntity> findAll();
    ProveedorProductoEntity save(ProveedorProductoEntity proveedorproducto);

    Optional<ProveedorProductoEntity> findById(ProveedorProductoId id);

    void deleteById(ProveedorProductoId id);
}
