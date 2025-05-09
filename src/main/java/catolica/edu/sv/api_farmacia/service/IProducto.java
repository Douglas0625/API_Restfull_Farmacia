package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.ProductoEntity;

import java.util.List;

public interface IProducto {

    List<ProductoEntity> findAll();
    ProductoEntity save(ProductoEntity producto);

}
