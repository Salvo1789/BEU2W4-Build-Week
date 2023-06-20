package epicode.bw5.services;

import org.springframework.beans.factory.annotation.Autowired;

import epicode.bw5.entities.Provincia;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.repositories.ProvinceRepository;

public class ProvinceService {
	@Autowired
	ProvinceRepository provinceRepo;

	public Provincia findBySigla(String sigla) throws NotFoundException {
		return provinceRepo.findBySigla(sigla)
				.orElseThrow(() -> new NotFoundException("Nessuna provincia con nome: " + sigla + " trovata"));
	}
}
