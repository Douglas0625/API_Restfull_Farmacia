package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVenta")
    private Long idVenta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IdCliente", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IdEmpleado", nullable = false)
    private EmpleadoEntity empleado;

    @Column(name = "FechaVenta")
    private LocalDateTime fechaVenta;

//    @Column(columnDefinition = "INT")
//    private int IdCliente;
//
//    @Column(columnDefinition = "INT")
//    private int IdEmpleado;
}

