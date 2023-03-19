package uea.cautela_drive.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import uea.cautela_drive.models.Motorista;
import uea.cautela_drive.services.MotoristaService;

@RestController
@RequestMapping("/motorista")
public class MotoristaResource {
	@Autowired
	private MotoristaService motoristaService;
	
	@PostMapping
	public ResponseEntity<Motorista> criar(@Valid @RequestBody Motorista motorista){
		Motorista motoristaSalvo = motoristaService.criar(motorista);
		return ResponseEntity.ok().body(motoristaSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Motorista>> listar(){
		List<Motorista> motoristas = motoristaService.listar();
		return ResponseEntity.ok().body(motoristas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Motorista> buscarPorCodigo(@PathVariable Long id){
		Motorista motorista = motoristaService.buscarPorCodigo(id);
		return ResponseEntity.ok().body(motorista);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Motorista> atualizar(@Valid @PathVariable Long id, @RequestBody Motorista motorista){
		Motorista motoristaSalvo = motoristaService.atualizar(id, motorista);
		return ResponseEntity.ok().body(motoristaSalvo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Motorista> excluir(@PathVariable Long id){
		motoristaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
}