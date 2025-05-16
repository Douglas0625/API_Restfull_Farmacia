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

//    public List<ClienteEntity> findByIDCliente(@PathVariable("idCliente") long idCliente) {
//        return iCliente.findByIdCliente(idCliente);
//    }

    @Transactional
    @PostMapping("/cliente")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) {
        return iCliente.save(cliente);
    }

}
