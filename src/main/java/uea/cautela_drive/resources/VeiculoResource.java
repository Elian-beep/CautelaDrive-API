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
import uea.cautela_drive.models.Veiculo;
import uea.cautela_drive.services.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public ResponseEntity<Veiculo> criar(@Valid @RequestBody Veiculo veiculo){
		Veiculo veiculoSalvo = veiculoService.criar(veiculo);
		return ResponseEntity.ok().body(veiculoSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> listar(){
		List<Veiculo> veiculos = veiculoService.listar();
		return ResponseEntity.ok().body(veiculos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> buscarPorCodigo(@PathVariable Long id){
		Veiculo veiculo = veiculoService.buscarPorCodigo(id);
		return ResponseEntity.ok().body(veiculo);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Veiculo> atualizar(@Valid @PathVariable Long id, @RequestBody Veiculo veiculo){
		Veiculo veiculoSalvo = veiculoService.atualizar(id, veiculo);
		return ResponseEntity.ok().body(veiculoSalvo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Veiculo> excluir(@PathVariable Long id){
		veiculoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
