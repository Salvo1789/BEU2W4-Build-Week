package epicode.bw5.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.bw5.entities.Cliente;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.repositories.ClientiRepository;

@Service
public class ClientiService {
	@Autowired
	private ClientiRepository clientiRepo;

	public Cliente findById(UUID id) throws NotFoundException {
		return clientiRepo.findById(id).orElseThrow(() -> new NotFoundException("Cliente non trovato!"));

	}
}
