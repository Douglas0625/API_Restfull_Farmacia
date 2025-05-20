package catolica.edu.sv.api_farmacia.service.Impl;

import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.EmpleadoEntity;
import catolica.edu.sv.api_farmacia.repository.EmpleadoRepository;
import catolica.edu.sv.api_farmacia.service.IEmpleado;

import java.util.List;

@Service
public class EmpleadoImpl implements IEmpleado {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> findAll(){
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<EmpleadoEntity> findByIdEmpleado(long idEmpleado) {
        return empleadoRepository.findByIdEmpleado(idEmpleado);
    }


}
