package epicode.bw5.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import epicode.bw5.entities.Cliente;
import epicode.bw5.entities.Fattura;
import epicode.bw5.entities.Indirizzo;
import epicode.bw5.entities.payloads.ModificaClientePayload;
import epicode.bw5.services.ClientiService;

@RestController
@RequestMapping("/clienti")
public class ClientiController {
	@Autowired
	ClientiService clientiService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Cliente> getClienti(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "0") long fatturato,
			@RequestParam(required = false) Optional<LocalDate> dataInserimento,
			@RequestParam(required = false) Optional<LocalDate> dataUltimoContatto,
			@RequestParam(defaultValue = "") String nomeCliente) {
		return clientiService.find(page, size, sortBy, fatturato, dataInserimento.orElse(null),
				dataUltimoContatto.orElse(null), nomeCliente);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente createCliente(@RequestBody ModificaClientePayload body) {
		return clientiService.create(body);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Cliente getByIdAndUpdate(@PathVariable UUID id, @RequestBody ModificaClientePayload body) {
		return clientiService.findByIdAndUpdate(id, body);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Cliente getById(@PathVariable UUID id) throws Exception {
		return clientiService.findById(id);
	}

	@GetMapping("/{id}/indirizzi")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<Indirizzo> listaIndirizzi(@PathVariable UUID id) throws Exception {
		return clientiService.getListaIndirizziByIdCliente(id);
	}

	@GetMapping("/{id}/fatture")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<Fattura> listaFatture(@PathVariable UUID id) throws Exception {
		return clientiService.getListaFattureByIdCliente(id);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable UUID id) {
		clientiService.findByIdAndDelete(id);
	}

}
