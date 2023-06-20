package epicode.bw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.bw5.entities.Comune;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.repositories.ComuniRepository;

@Service
public class ComuniService {

	@Autowired
	ComuniRepository comuniRepo;

	public Comune findByNome(String nome) throws NotFoundException {
		return comuniRepo.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Nessun comune con nome: " + nome + " trovato"));
	}
}
