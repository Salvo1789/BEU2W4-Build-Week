package epicode.bw5.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import epicode.bw5.entities.Indirizzo;
import epicode.bw5.entities.payloads.AssegnaIndirizzoPayload;
import epicode.bw5.entities.payloads.ModificaIndirizzoPayload;
import epicode.bw5.services.IndirizziService;

@RestController
@RequestMapping("/indirizzi")
public class IndirizziController {
	@Autowired
	IndirizziService indirizziService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Indirizzo> getIndirizzo(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return indirizziService.find(page, size, sortBy);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Indirizzo createIndirizzo(@RequestBody ModificaIndirizzoPayload body) {
		return indirizziService.create(body);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Indirizzo getByIdAndUpdate(@PathVariable UUID id, @RequestBody ModificaIndirizzoPayload body) {
		return indirizziService.findByIdAndUpdate(id, body);
	}

	@PatchMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Indirizzo AssegnaCliente(@PathVariable UUID id, @RequestBody AssegnaIndirizzoPayload body) {
		return indirizziService.assegnaCliente(id, body);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Indirizzo getById(@PathVariable UUID id) throws Exception {
		return indirizziService.findById(id);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteIndirizzo(@PathVariable UUID id) {
		indirizziService.findByIdAndDelete(id);
	}
}
