package catolica.edu.sv.api_farmacia.entities.payload;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
public class MessageResponse {

    private String message;

    private Object data;

}
