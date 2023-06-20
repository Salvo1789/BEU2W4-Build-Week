package epicode.bw5.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class IdComune implements Serializable {

	public String codProvincia;

	public String progressivoComune;
}
