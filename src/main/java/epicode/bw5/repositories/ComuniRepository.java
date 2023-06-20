package epicode.bw5.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Comune;

@Repository
public interface ComuniRepository extends JpaRepository<Comune, String> {
	Optional<Comune> findByNome(String nome);
}
