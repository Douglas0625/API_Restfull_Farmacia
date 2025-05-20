package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import catolica.edu.sv.api_farmacia.entities.EmpleadoEntity;
import catolica.edu.sv.api_farmacia.entities.ProveedorEntity;

import java.util.List;

public interface IEmpleado {

    List<EmpleadoEntity> findAll();

    //crear Endpoints POST equicalente al insert en SQL
    EmpleadoEntity save(EmpleadoEntity empleado);

    List<EmpleadoEntity> findByIdEmpleado(long idEmpleado);


}
