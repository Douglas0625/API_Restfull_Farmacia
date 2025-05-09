package catolica.edu.sv.api_farmacia.service;


import catolica.edu.sv.api_farmacia.entities.ProveedorProductoEntity;

import java.util.List;
public interface IProveedorProducto {

    List<ProveedorProductoEntity> findAll();
    ProveedorProductoEntity save(ProveedorProductoEntity proveedorproducto);
}
