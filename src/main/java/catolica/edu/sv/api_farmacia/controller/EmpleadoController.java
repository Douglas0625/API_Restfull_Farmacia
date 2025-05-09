package catolica.edu.sv.api_farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    @PostMapping("/empleados")
    public EmpleadoEntity saveEmpleado(@RequestBody EmpleadoEntity empleado){
        return iEmpleado.save(empleado);
    }

}
