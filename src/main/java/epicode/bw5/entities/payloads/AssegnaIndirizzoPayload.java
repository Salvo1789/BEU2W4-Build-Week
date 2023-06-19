package epicode.bw5.entities.payloads;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssegnaIndirizzoPayload {

	@NotNull(message = "L'id del cliente è abbligatorio")
	private UUID idCliente;
}
