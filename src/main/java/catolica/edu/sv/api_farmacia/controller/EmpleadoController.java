package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.dto.EmpleadoRequestDTO;
import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import catolica.edu.sv.api_farmacia.entities.ProductoEntity;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import catolica.edu.sv.api_farmacia.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import catolica.edu.sv.api_farmacia.entities.EmpleadoEntity;
import catolica.edu.sv.api_farmacia.service.IEmpleado;
import java.util.List;

@RestController
@RequestMapping("/process")
public class EmpleadoController {

    @Autowired
    private IEmpleado iEmpleado;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional(readOnly = true)
    @GetMapping("/empleados")
    public List<EmpleadoEntity> getEmpleados(){
        return iEmpleado.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/consultarEmpleado/{idEmpleado}")
    public ResponseEntity<?>  findByIdEmpleado(@PathVariable Long idEmpleado) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito.")
                .data(iEmpleado.findByIdEmpleado(idEmpleado))
                .build(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/empleado")
    public ResponseEntity<?> saveEmpleado(@RequestBody EmpleadoRequestDTO dto) {
        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setCargo(dto.getCargo());
        empleado.setSalario(dto.getSalario());

        iEmpleado.save(empleado);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Empleado registrado correctamente.")
                .data(empleado)
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/empleado/{idEmpleado}")
    public ResponseEntity<?> udateEmpleado(@PathVariable Long idEmpleado, @RequestBody EmpleadoEntity empleadoRequest) {
        List<EmpleadoEntity> empleadosExistentes = iEmpleado.findByIdEmpleado(idEmpleado);

        if (empleadosExistentes.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Empleado no encontrado con el ID: " + idEmpleado)
                    .build(), HttpStatus.NOT_FOUND);
        }

        EmpleadoEntity empleadoExistente = empleadosExistentes.get(0);

        // Actualizar campos
        empleadoExistente.setNombre(empleadoRequest.getNombre());
        empleadoExistente.setApellido(empleadoRequest.getApellido());
        empleadoExistente.setCargo(empleadoRequest.getCargo());
        empleadoExistente.setSalario(empleadoRequest.getSalario());

        // Guardar actualizado
        EmpleadoEntity empleadoActualizado = iEmpleado.save(empleadoExistente);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Empleado actualizado correctamente.")
                .data(empleadoActualizado)
                .build(), HttpStatus.OK);
    }




    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable Long id) {
        EmpleadoEntity existente = empleadoRepository.findById(id).orElse(null);

        if (existente == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Empleado no encontrado con ID: " + id)
                    .build(), HttpStatus.NOT_FOUND);
        }

        empleadoRepository.deleteById(id);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Empleado eliminado correctamente.")
                .build(), HttpStatus.OK);
    }
}
