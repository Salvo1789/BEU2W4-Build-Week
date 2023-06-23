package epicode.bw5.repositories;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Fattura;
import epicode.bw5.entities.StatoFattura;

@Repository
public interface FattureRepository extends JpaRepository<Fattura, UUID> {
	Optional<Fattura> findByNumero(int numero);

	Page<Fattura> findByStato(StatoFattura stato, Pageable pageable);

	Page<Fattura> findByData(LocalDate data, Pageable pageable);

	Page<Fattura> findByAnno(int anno, Pageable pageable);

	@Query("SELECT f FROM Fattura f WHERE f.importo >= :importo1 AND f.importo <= :importo2")
	Page<Fattura> findByImportoBetween(double importo1, double importo2, Pageable pageable);
}
