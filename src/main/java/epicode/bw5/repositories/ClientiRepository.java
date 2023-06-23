package epicode.bw5.repositories;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Cliente;

@Repository
public interface ClientiRepository extends JpaRepository<Cliente, UUID> {
	Optional<Cliente> findByEmail(String email);

	Optional<Cliente> findByEmailContatto(String email);

	Optional<Cliente> findByRagioneSociale(String nomeCliente);

	Page<Cliente> findByFatturatoAnnuale(long fatturato, Pageable pageable);

	Page<Cliente> findByDataInserimento(LocalDate dataInserimento, Pageable pageable);

	Page<Cliente> findByDataUltimoContatto(LocalDate dataUltimoContatto, Pageable pageable);

	Page<Cliente> findByRagioneSocialeContaining(String nomeCliente, Pageable pageable);

}
