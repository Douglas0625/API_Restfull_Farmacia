package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proveedor")

public class ProveedorEntity {

    @Id
    @Column(columnDefinition = "INT",name = "IdProveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdProveedor;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Nombre;

    @Column(columnDefinition = "VARCHAR(150)")
    private String Correo;

    @Column(columnDefinition = "VARCHAR(15)")
    private String Telefono;
}
