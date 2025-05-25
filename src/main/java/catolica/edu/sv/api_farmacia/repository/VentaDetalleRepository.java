package catolica.edu.sv.api_farmacia.repository;

import catolica.edu.sv.api_farmacia.entities.VentaDetalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import catolica.edu.sv.api_farmacia.entities.VentaDetalleEntity;

@Repository
public interface VentaDetalleRepository extends JpaRepository<VentaDetalleEntity, VentaDetalleId> {
}
