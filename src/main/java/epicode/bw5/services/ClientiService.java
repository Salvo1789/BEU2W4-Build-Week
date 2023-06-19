package epicode.bw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.bw5.repositories.ClientiRepository;

@Service
public class ClientiService {
	@Autowired
	private ClientiRepository clientiRepo;
}
