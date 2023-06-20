package epicode.bw5.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comuni")
@IdClass(IdComune.class)
public class Comune {

	@Id
	public String codProvincia;
	@Id
	public String progressivoComune;
	private String nome;
	@ManyToOne
	private Provincia provincia;
	@OneToMany(mappedBy = "comune")
	@JsonIgnore
	private List<Indirizzo> elencoIndirizzi;

	public Comune(String codProvincia, String progressivoComune, String nome, Provincia provincia) {
		super();
		this.codProvincia = codProvincia;
		this.progressivoComune = progressivoComune;
		this.nome = nome;
		this.provincia = provincia;
	}

}
