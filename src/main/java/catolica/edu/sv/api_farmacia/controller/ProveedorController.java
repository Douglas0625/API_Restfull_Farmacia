package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.dto.ProveedorResquestDTO;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import catolica.edu.sv.api_farmacia.entities.ProveedorEntity;
import catolica.edu.sv.api_farmacia.service.IProveedor;

import java.util.List;
@RestController
@RequestMapping("/process")
public class ProveedorController {

    @Autowired
    private IProveedor iProveedor;

    @Transactional(readOnly = true)
    @GetMapping("/proveedores")
    public ResponseEntity<?> getProveedores() {
        List<ProveedorEntity> proveedores = iProveedor.findAll();
        return ResponseEntity.ok(
                MessageResponse.builder()
                        .message("Lista de proveedores obtenida con éxito.")
                        .data(proveedores)
                        .build()
        );
    }

    @Transactional
    @PostMapping("/proveedores")
    public ResponseEntity<?> saveProveedor(@RequestBody ProveedorResquestDTO dto) {
        ProveedorEntity proveedor = new ProveedorEntity();

        proveedor.setIdProveedor(dto.getIdproveedor());
        proveedor.setNombre(dto.getNombre());
        proveedor.setCorreo(dto.getCorreo());
        proveedor.setTelefono(dto.getTelefono());

        ProveedorEntity saved = iProveedor.save(proveedor);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Proveedor registrado correctamente.")
                        .data(saved)
                        .build(),
                HttpStatus.CREATED
        );
    }

    @Transactional
    @PutMapping("/proveedores/{id}")
    public ResponseEntity<?> updateProveedor(@PathVariable Long id, @RequestBody ProveedorResquestDTO dto) {
        ProveedorEntity proveedorExistente = iProveedor.findById(id).orElse(null);

        if (proveedorExistente == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Proveedor no encontrado con id: " + id)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }

        proveedorExistente.setNombre(dto.getNombre());
        proveedorExistente.setCorreo(dto.getCorreo());
        proveedorExistente.setTelefono(dto.getTelefono());

        ProveedorEntity actualizado = iProveedor.save(proveedorExistente);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Proveedor actualizado correctamente.")
                        .data(actualizado)
                        .build(),
                HttpStatus.OK
        );
    }

    @Transactional
    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable Long id) {
        ProveedorEntity proveedor = iProveedor.findById(id).orElse(null);

        if (proveedor == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Proveedor no encontrado con id: " + id)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }

        iProveedor.deleteById(id);

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Proveedor eliminado correctamente.")
                        .build(),
                HttpStatus.OK
        );
    }
}
