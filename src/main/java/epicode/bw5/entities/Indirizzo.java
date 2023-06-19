package epicode.bw5.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "indirizzi")
public class Indirizzo {
	@Id
	@GeneratedValue
	private UUID id;
	private String via;
	private String civico;
	private String localita;
	private int cap;
	private String comune;
	@ManyToOne
	private Cliente cliente;

	public Indirizzo(String via, String civico, String localita, int cap, String comune, Cliente cliente) {
		super();
		this.via = via;
		this.civico = civico;
		this.localita = localita;
		this.cap = cap;
		this.comune = comune;
		this.cliente = cliente;
	}
}