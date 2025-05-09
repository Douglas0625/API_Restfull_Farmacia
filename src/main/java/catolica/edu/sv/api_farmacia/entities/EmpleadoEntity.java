package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class EmpleadoEntity {

    @Id
    @Column(columnDefinition = "INT", name = "IdEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdEmpleado;

    @Column(columnDefinition = "VARCHAR(50)")
    private String Nombre;

    @Column(columnDefinition = "VARCHAR(50)")
    private String Apellido;

    @Column(columnDefinition = "VARCHAR(50)")
    private String Cargo;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private double Salario;

}
