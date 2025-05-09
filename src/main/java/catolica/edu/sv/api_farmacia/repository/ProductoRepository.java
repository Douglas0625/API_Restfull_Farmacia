package catolica.edu.sv.api_farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import catolica.edu.sv.api_farmacia.entities.ProductoEntity;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{

}
