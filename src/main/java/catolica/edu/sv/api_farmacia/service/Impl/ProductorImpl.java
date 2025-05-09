package catolica.edu.sv.api_farmacia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.ProductoEntity;
import catolica.edu.sv.api_farmacia.repository.ProductoRepository;
import catolica.edu.sv.api_farmacia.service.IProducto;

import java.util.List;

@Service
public class ProductorImpl implements IProducto {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> findAll(){
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity save(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

}
