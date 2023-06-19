package epicode.bw5.entities.payloads;

import java.time.LocalDate;

import epicode.bw5.entities.TipoCliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificaClientePayload {
	@NotNull(message = "La ragione sociale è obbligatoria")
	private String ragioneSociale;
	@NotNull(message = "Il tipo cliente è obbligatorio")
	private TipoCliente tipo;
	@NotNull(message = "La partita IVA è obbligatoria")
	private String partitaIva;
	@Email(message = "Non hai inserito un indirizzo email valido")
	private String email;
	@NotNull(message = "La data è obbligatoria")
	private LocalDate dataInserimento;
	@NotNull(message = "La data è obbligatoria")
	private LocalDate dataUltimoContatto;
	@NotNull(message = "Il numero del fatturato annuale è obbligatorio")
	private Long fatturatoAnnuale;
	@NotNull(message = "L'indirizzo PEC è obbligatorio")
	private String pec;
	@NotNull(message = "Il numero di telefono è obbligatorio")
	private String telefono;
	@Email(message = "Non hai inserito un indirizzo email valido")
	private String emailContatto;
	@NotNull(message = "Il nome del contatto è obbligatorio")
	private String nomeContatto;
	@NotNull(message = "Il cognome del contatto è obbligatorio")
	private String cognomeContatto;
	@NotNull(message = "Il numero del contatto è obbligatorio")
	private String telefonoContatto;

}
