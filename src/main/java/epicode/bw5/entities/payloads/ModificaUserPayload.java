package epicode.bw5.entities.payloads;

import epicode.bw5.entities.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificaUserPayload {
	@NotNull(message = "L'username è obbligatorio")
	@Size(min = 3, max = 30, message = "Nome min 3 caratteri, massimo 30")
	String username;

	@NotNull(message = "La password è obbligatoria")
	String password;
	@NotNull(message = "Il nome è obbligatorio")
	String nome;
	@NotNull(message = "Il Cognome è obbligatorio")
	String cognome;

	@NotNull(message = "Il Role è obbligatorio")
	Role role;
}
