package epicode.bw5.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Fattura;
import epicode.bw5.entities.StatoFattura;

@Repository
public interface FattureRepository extends JpaRepository<Fattura, UUID> {
	Optional<Fattura> findByNumero(int numero);

	List<Fattura> findByStato(StatoFattura stato);

}
