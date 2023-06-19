package epicode.bw5.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Fattura;

@Repository
public interface FattureRepository extends JpaRepository<Fattura, UUID> {
	Optional<Fattura> findByNumero(int numero);
}
