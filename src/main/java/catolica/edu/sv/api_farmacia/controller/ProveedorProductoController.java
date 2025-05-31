package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.dto.ProveedorProductoRequestDTO;
import catolica.edu.sv.api_farmacia.entities.*;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import catolica.edu.sv.api_farmacia.repository.ProductoRepository;
import catolica.edu.sv.api_farmacia.repository.ProveedorRepository;
import catolica.edu.sv.api_farmacia.service.IProveedorProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class ProveedorProductoController {

    @Autowired
    private IProveedorProducto iProveedorProducto;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @GetMapping("/proveedorProductos")
    public ResponseEntity<?> getProveedorProductos() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito.")
                .data(iProveedorProducto.findAll())
                .build(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/proveedorProducto")
    public ResponseEntity<?> saveProveedorProducto(@RequestBody ProveedorProductoRequestDTO dto) {
        ProveedorEntity proveedor = proveedorRepository.findById(dto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        ProductoEntity producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        ProveedorProductoId id = new ProveedorProductoId(dto.getIdProveedor(), dto.getIdProducto());

        ProveedorProductoEntity entidad = new ProveedorProductoEntity();
        entidad.setId(id);
        entidad.setProveedor(proveedor);
        entidad.setProducto(producto);

        iProveedorProducto.save(entidad);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Relación proveedor-producto registrada correctamente.")
                .data(entidad)
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/proveedorproducto/{idProveedor}/{idProducto}")
    public ResponseEntity<?> updateProveedorProducto(
            @PathVariable long idProveedor,
            @PathVariable long idProducto,
            @RequestBody ProveedorProductoRequestDTO dto) {

        ProveedorProductoId id = new ProveedorProductoId(idProveedor, idProducto);
        ProveedorProductoEntity existente = iProveedorProducto.findById(id).orElse(null);

        if (existente == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Relación proveedor-producto no encontrada con idProveedor: " + idProveedor + " y idProducto: " + idProducto)
                    .build(), HttpStatus.NOT_FOUND);
        }

        ProveedorEntity nuevoProveedor = proveedorRepository.findById(dto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        ProductoEntity nuevoProducto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        iProveedorProducto.deleteById(id);


        ProveedorProductoEntity actualizado = new ProveedorProductoEntity();
        actualizado.setId(new ProveedorProductoId(dto.getIdProveedor(), dto.getIdProducto()));
        actualizado.setProveedor(nuevoProveedor);
        actualizado.setProducto(nuevoProducto);

        iProveedorProducto.save(actualizado);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Relacion proveedor-producto actualizada correctamente.")
                .data(actualizado)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/proveedorproducto/{idProveedor}/{idProducto}")
    public ResponseEntity<?> deleteProveedorProducto(
            @PathVariable long idProveedor,
            @PathVariable long idProducto) {
        ProveedorProductoId id = new ProveedorProductoId(idProveedor, idProducto);
        ProveedorProductoEntity existente = iProveedorProducto.findById(id).orElse(null);

        if (existente == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Relación proveedor-producto no encontrada con idProveedor: " + idProveedor + " y idProducto: " + idProducto)
                    .build(), HttpStatus.NOT_FOUND);
        }

        iProveedorProducto.deleteById(id);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Relacion proveedor-producto eliminado correctamente.")
                .build(), HttpStatus.OK);
    }


    }



