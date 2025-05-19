package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import catolica.edu.sv.api_farmacia.service.ICliente;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ClienteController {

    @Autowired
    private ICliente iCliente;

    @Transactional(readOnly = true)
    @GetMapping("/clientes")
    public ResponseEntity<?> getClientes() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito.")
                .data(iCliente.findAll())
                .build(),HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/consultarCliente/{idCliente}")
    public ResponseEntity<?>  findByIdCliente(@PathVariable Long idCliente) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito.")
                .data(iCliente.findByIdCliente(idCliente))
                .build(), HttpStatus.OK);
    }


    @Transactional
    @PostMapping("/cliente")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) {
        return iCliente.save(cliente);
    }

    @PutMapping("/cliente/{idCliente}")
    public ResponseEntity<?> updateCliente(@PathVariable Long idCliente, @RequestBody ClienteEntity clienteRequest) {
        List<ClienteEntity> clientesExistentes = iCliente.findByIdCliente(idCliente);

        if (clientesExistentes.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Cliente no encontrado con el ID: " + idCliente)
                    .build(), HttpStatus.NOT_FOUND);
        }

        ClienteEntity clienteExistente = clientesExistentes.get(0);

        // Actualizar campos
        clienteExistente.setNombre(clienteRequest.getNombre());
        clienteExistente.setApellido(clienteRequest.getApellido());
        clienteExistente.setCorreo(clienteRequest.getCorreo());
        clienteExistente.setTelefono(clienteRequest.getTelefono());
        clienteExistente.setMembresia(clienteRequest.isMembresia());

        // Guardar actualizado
        ClienteEntity clienteActualizado = iCliente.save(clienteExistente);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Cliente actualizado correctamente.")
                .data(clienteActualizado)
                .build(), HttpStatus.OK);
    }

}
