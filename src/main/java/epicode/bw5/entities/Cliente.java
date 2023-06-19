package epicode.bw5.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clienti")
public class Cliente {
	@Id
	@GeneratedValue
	private UUID id;
	private String ragioneSociale;
	@Enumerated(EnumType.STRING)
	private TipoCliente tipo;
	private String partitaIva;
	private String email;
	private LocalDate dataInserimento;
	private LocalDate dataUltimoContatto;
	private Long fatturatoAnnuale;
	private String pec;
	private String telefono;
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	private String telefonoContatto;
	@OneToMany(mappedBy = "cliente")
	private List<Fattura> listaFatture;
	@OneToMany(mappedBy = "cliente")
	private List<Indirizzo> listaIndirizzi;

	public Cliente(String ragioneSociale, TipoCliente tipo, String partitaIva, String email, LocalDate dataInserimento,
			LocalDate dataUltimoContatto, Long fatturatoAnnuale, String pec, String telefono, String emailContatto,
			String nomeContatto, String cognomeContatto, String telefonoContatto) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.tipo = tipo;
		this.partitaIva = partitaIva;
		this.email = email;
		this.dataInserimento = dataInserimento;
		this.dataUltimoContatto = dataUltimoContatto;
		this.fatturatoAnnuale = fatturatoAnnuale;
		this.pec = pec;
		this.telefono = telefono;
		this.emailContatto = emailContatto;
		this.nomeContatto = nomeContatto;
		this.cognomeContatto = cognomeContatto;
		this.telefonoContatto = telefonoContatto;
		this.listaFatture = new ArrayList<>();
		this.listaIndirizzi = new ArrayList<>();
	}

}
