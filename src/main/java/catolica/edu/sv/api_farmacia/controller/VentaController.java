package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.dto.VentaRequestDTO;
import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import catolica.edu.sv.api_farmacia.entities.EmpleadoEntity;
import catolica.edu.sv.api_farmacia.entities.VentaEntity;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import catolica.edu.sv.api_farmacia.repository.ClienteRepository;
import catolica.edu.sv.api_farmacia.repository.EmpleadoRepository;
import catolica.edu.sv.api_farmacia.service.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class VentaController {

    @Autowired
    private IVenta iVenta;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional(readOnly = true)
    @GetMapping("/ventas")
    public ResponseEntity<?> getVentas() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con éxito.")
                .data(iVenta.findAll())
                .build(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/venta")
    public ResponseEntity<?> saveVenta(@RequestBody VentaRequestDTO dto) {
        ClienteEntity cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        EmpleadoEntity empleado = empleadoRepository.findById(dto.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        VentaEntity venta = new VentaEntity();
        venta.setCliente(cliente);
        venta.setEmpleado(empleado);
        venta.setFechaVenta(dto.getFechaVenta());

        iVenta.save(venta);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Venta registrada correctamente.")
                .data(venta)
                .build(), HttpStatus.CREATED);
    }
}

