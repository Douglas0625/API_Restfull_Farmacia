package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")

public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCliente", nullable = false, updatable = false)
    private Long IdCliente;

    @Column(columnDefinition = "VARCHAR(50)")
    private String Nombre;

    @Column(columnDefinition = "VARCHAR(50)")
    private String Apellido;

    @Column(columnDefinition = "VARCHAR(150)")
    private String Correo;

    @Column(columnDefinition = "VARCHAR(15)")
    private String Telefono;

    @Column(columnDefinition = "BOOLEAN")
    private boolean Membresia;

}
