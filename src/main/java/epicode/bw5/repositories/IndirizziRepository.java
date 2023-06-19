package epicode.bw5.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Indirizzo;

@Repository
public interface IndirizziRepository extends JpaRepository<Indirizzo, UUID> {

}
