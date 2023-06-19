package epicode.bw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.bw5.repositories.FattureRepository;

@Service
public class FattureService {
	@Autowired
	private FattureRepository fattureRepo;
}
