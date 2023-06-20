package epicode.bw5.entities;

import jakarta.persistence.Entity;
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
@Table(name = "comuni")
public class Comune {

	@Id
	private String codProvincia;
	@Id
	private String progressivoComune;
	private String nome;
	@ManyToOne
	private Provincia provincia;

	public Comune(String codProvincia, String progressivoComune, String nome, Provincia provincia) {
		super();
		this.codProvincia = codProvincia;
		this.progressivoComune = progressivoComune;
		this.nome = nome;
		this.provincia = provincia;
	}

}
