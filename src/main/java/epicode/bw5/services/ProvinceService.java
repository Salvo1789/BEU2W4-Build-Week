package epicode.bw5.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import epicode.bw5.entities.Provincia;
import epicode.bw5.exceptions.NotFoundException;
import epicode.bw5.helper.CSVHelper;
import epicode.bw5.repositories.ProvinceRepository;

@Service
public class ProvinceService {
	@Autowired
	ProvinceRepository provinceRepo;

	public Provincia findBySigla(String sigla) throws NotFoundException {
		return provinceRepo.findBySigla(sigla)
				.orElseThrow(() -> new NotFoundException("Nessuna provincia con nome: " + sigla + " trovata"));
	}

	public void save(MultipartFile file) {
		try {
			List<Provincia> province = CSVHelper.csvToProvince(file.getInputStream());
			provinceRepo.saveAll(province);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<Provincia> getAllProvince() {
		return provinceRepo.findAll();
	}
}
