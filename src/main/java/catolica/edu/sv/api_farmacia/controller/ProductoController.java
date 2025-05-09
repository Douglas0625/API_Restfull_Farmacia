package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.service.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import catolica.edu.sv.api_farmacia.entities.ProductoEntity;
import catolica.edu.sv.api_farmacia.service.IProducto;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProductoController {

    @Autowired
    private IProducto iProducto;

    @Transactional(readOnly = true)
    @GetMapping("/productos")
    public List<ProductoEntity> getProductos() {
        return iProducto.findAll();
    }

    @Transactional
    @PostMapping("/productos")
    public ProductoEntity saveProducto(@RequestBody ProductoEntity producto) {
        return iProducto.save(producto);
    }

}
