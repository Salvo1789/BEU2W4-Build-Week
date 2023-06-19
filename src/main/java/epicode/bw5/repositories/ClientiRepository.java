package epicode.bw5.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.bw5.entities.Cliente;

@Repository
public interface ClientiRepository extends JpaRepository<Cliente, UUID> {

}
