package epicode.bw5.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import epicode.bw5.entities.Provincia;

public interface ProvinceRepository extends JpaRepository<Provincia, String> {
	Optional<Provincia> findBySigla(String sigla);
}
