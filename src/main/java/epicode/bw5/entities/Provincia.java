package epicode.bw5.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
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
@Table(name = "province")
public class Provincia {

	@Id
	private String sigla;
	private String nome;
	private String regione;

	@OneToMany(mappedBy = "provincia")
	@JsonIgnore
	private List<Comune> elencoComuni;

	public Provincia(String sigla, String nome, String regione) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.regione = regione;
	}

}
