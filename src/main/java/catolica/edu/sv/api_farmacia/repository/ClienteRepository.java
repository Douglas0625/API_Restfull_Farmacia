package catolica.edu.sv.api_farmacia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import catolica.edu.sv.api_farmacia.entities.ClienteEntity;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query("SELECT p FROM ClienteEntity p WHERE p.IdCliente = :idCliente")
    List<ClienteEntity> findByIdCliente(@Param("idCliente") Long idCliente);

}
