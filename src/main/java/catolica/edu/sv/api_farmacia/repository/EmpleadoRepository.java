package catolica.edu.sv.api_farmacia.repository;

import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import catolica.edu.sv.api_farmacia.entities.EmpleadoEntity;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

    @Query("SELECT p FROM EmpleadoEntity p WHERE p.IdEmpleado = :idEmpleado")
    List<EmpleadoEntity> findByIdEmpleado(@Param("idEmpleado") Long idEmpleado);
}
