package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
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
    @PostMapping("/empleados")
    public EmpleadoEntity saveEmpleado(@RequestBody EmpleadoEntity empleado){
        return iEmpleado.save(empleado);
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
}
