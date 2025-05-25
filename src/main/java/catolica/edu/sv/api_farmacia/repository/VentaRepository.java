package catolica.edu.sv.api_farmacia.repository;

import catolica.edu.sv.api_farmacia.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import catolica.edu.sv.api_farmacia.entities.VentaEntity;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {

    @Query("SELECT p FROM VentaEntity p WHERE p.idVenta = :idVenta")
    List<VentaEntity> findByIdVenta(@Param("idVenta") Long idVenta);
}
