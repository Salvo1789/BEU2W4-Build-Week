package epicode.bw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.bw5.repositories.IndirizziRepository;

@Service
public class IndirizziService {
	@Autowired
	private IndirizziRepository indirizziRepo;
}
