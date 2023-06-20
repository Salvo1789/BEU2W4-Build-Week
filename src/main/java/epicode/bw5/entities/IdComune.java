package epicode.bw5.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IdComune implements Serializable {

	public String codProvincia;

	public String progressivoComune;
}
