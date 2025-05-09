package catolica.edu.sv.api_farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import catolica.edu.sv.api_farmacia.entities.ProveedorProductoEntity;

import java.util.List;

@Repository
public interface ProveedorProductoRepository extends JpaRepository<ProveedorProductoEntity, Long> {
}
