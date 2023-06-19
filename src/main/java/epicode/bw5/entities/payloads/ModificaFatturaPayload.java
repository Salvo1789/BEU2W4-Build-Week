package epicode.bw5.entities.payloads;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificaFatturaPayload {
	@NotNull(message = "L'anno è abbligatorio")
	private int anno;
	@NotNull(message = "La data è abbligatoria")
	private LocalDate data;
	@NotNull(message = "L'importo è abbligatorio")
	private BigDecimal importo;
	@NotNull(message = "L'id cliente è abbligatorio")
	private UUID idCliente;
}
