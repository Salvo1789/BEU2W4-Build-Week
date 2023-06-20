package epicode.bw5.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "fatture")
public class Fattura {

	@Id
	@GeneratedValue
	private UUID id;
	private int numero;
	private int anno;
	private LocalDate data;
	private BigDecimal importo;
	@Enumerated(EnumType.STRING)

	private StatoFattura stato;
	@ManyToOne
	@JsonBackReference
	private Cliente cliente;

	public Fattura(int numero, int anno, LocalDate data, BigDecimal importo, Cliente cliente) {
		super();
		this.numero = numero;
		this.anno = anno;
		this.data = data;
		this.importo = importo;
		this.cliente = cliente;
		this.stato = StatoFattura.DA_RISCUOTERE;
	}
}
