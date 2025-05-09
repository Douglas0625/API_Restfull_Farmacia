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
}

