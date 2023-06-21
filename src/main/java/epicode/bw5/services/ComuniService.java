package epicode.bw5.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import epicode.bw5.entities.Comune;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.helper.CSVHelper;
import epicode.bw5.repositories.ComuniRepository;

@Service
public class ComuniService {

	@Autowired
	ComuniRepository comuniRepo;

	@Autowired
	ProvinceService provinceService;

	public Comune findByNome(String nome) throws NotFoundException {
		return comuniRepo.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Nessun comune con nome: " + nome + " trovato"));
	}

	public void save(MultipartFile file) {
		try {
			List<Comune> comuni = CSVHelper.csvToComuni(file.getInputStream(), provinceService.getAllProvince());
			comuniRepo.saveAll(comuni);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<Comune> getAllComuni() {
		return comuniRepo.findAll();
	}
}
