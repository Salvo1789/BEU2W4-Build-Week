package epicode.bw5.entities.payloads;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificaIndirizzoPayload {
	@NotNull(message = "La via è abbligatoria")
	private String via;
	@NotNull(message = "Il numero civico è abbligatorio")
	private String civico;
	@NotNull(message = "La località è abbligatoria")
	private String localita;
	@NotNull(message = "Il cap è abbligatorio")
	private int cap;
	@NotNull(message = "Il comune è abbligatorio")
	private String nomeComune;
	@NotNull(message = "L'id del cliente è abbligatorio")
	private UUID idCliente;
}
