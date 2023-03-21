package uea.cautela_drive.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uea.cautela_drive.models.Coordenador;
import uea.cautela_drive.services.CoordenadorService;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorResource {
	@Autowired
	private CoordenadorService coordenadorService;
	
	@PostMapping
	public ResponseEntity<Coordenador> criar(@Valid @RequestBody Coordenador coordenador){
		Coordenador coordenadorSalvo = coordenadorService.criar(coordenador);
		return ResponseEntity.ok().body(coordenadorSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Coordenador>> listar(){
		List<Coordenador> coordenadors = coordenadorService.listar();
		return ResponseEntity.ok().body(coordenadors);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Coordenador> buscarPorCodigo(@PathVariable Long id){
		Coordenador coordenador = coordenadorService.buscarPorCodigo(id);
		return ResponseEntity.ok().body(coordenador);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Coordenador> atualizar(@Valid @PathVariable Long id, @RequestBody Coordenador coordenador){
		Coordenador coordenadorSalvo = coordenadorService.atualizar(id, coordenador);
		return ResponseEntity.ok().body(coordenadorSalvo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Coordenador> excluir(@PathVariable Long id){
		coordenadorService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
