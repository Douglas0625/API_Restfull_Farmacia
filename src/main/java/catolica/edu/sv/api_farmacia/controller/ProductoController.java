package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.dto.ProductoRequestDTO;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import catolica.edu.sv.api_farmacia.repository.ProductoRepository;
import catolica.edu.sv.api_farmacia.service.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import catolica.edu.sv.api_farmacia.entities.ProductoEntity;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProductoController {

    @Autowired
    private IProducto iProducto;
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @GetMapping("/productos")
    public ResponseEntity<?> getProductos() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito.")
                .data(iProducto.findAll())
                .build(),HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/productos")
    public ResponseEntity<?> saveProducto(@RequestBody ProductoRequestDTO dto) {
        ProductoEntity producto = new ProductoEntity();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setStock(dto.getStock());
        producto.setPrecio(dto.getPrecio());
        producto.setFechaCaducidad(dto.getFecha_caducidad());

        iProducto.save(producto);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Producto registrado correctamente.")
                .data(producto)
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> updateProducto(
            @PathVariable long id,
            @RequestBody ProductoRequestDTO dto) {

        ProductoEntity existente = productoRepository.findById(id).orElse(null);

        if (existente == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Producto no encontrado con ID: " + id)
                    .build(), HttpStatus.NOT_FOUND);
        }

        existente.setNombre(dto.getNombre());
        existente.setPrecio(dto.getPrecio());
        existente.setStock(dto.getStock());

        productoRepository.save(existente);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Producto actualizado correctamente.")
                .data(existente)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable long id) {
        ProductoEntity existente = productoRepository.findById(id).orElse(null);

        if (existente == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Producto no encontrado con ID: " + id)
                    .build(), HttpStatus.NOT_FOUND);
        }

        productoRepository.deleteById(id);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Producto eliminado correctamente.")
                .build(), HttpStatus.OK);
    }



}
