package uea.cautela_drive.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uea.cautela_drive.dto.ResumoDevolutivaDto;
import uea.cautela_drive.models.Devolutiva;
import uea.cautela_drive.models.Requisicao;
import uea.cautela_drive.repositories.filters.DevolutivaFilter;
import uea.cautela_drive.services.DevolutivaService;



@RestController
@RequestMapping("/devolutivas")
public class DevolutivaResource {
	
	@Autowired
	private DevolutivaService devolutivaService;
	
	@PostMapping
	public ResponseEntity<Devolutiva> criar(@RequestBody Devolutiva devolutiva){
		Devolutiva devolutivaSalva = devolutivaService.criar(devolutiva);
		return ResponseEntity.ok().body(devolutivaSalva);
	}
	
	@GetMapping(value = "/busca")
	public ResponseEntity<Page<ResumoDevolutivaDto>> resumir(DevolutivaFilter devolutivaFilter, Pageable pageable){
		Page<ResumoDevolutivaDto> resumos = devolutivaService.resumir(devolutivaFilter, pageable);
		return ResponseEntity.ok().body(resumos);
	}
	
	@GetMapping
	public ResponseEntity<List<Devolutiva>> listar(){
		List<Devolutiva> devolutivas = devolutivaService.listar();
		return ResponseEntity.ok().body(devolutivas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Devolutiva> buscarPorCodigo(@PathVariable Long id){
		Devolutiva devolutiva = devolutivaService.buscarPorId(id);
		return ResponseEntity.ok().body(devolutiva);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		devolutivaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Devolutiva> atualizar(@PathVariable Long id, @RequestBody Devolutiva devolutiva){
		Devolutiva devolutivaSalva = devolutivaService.atualizar(id, devolutiva);
		return ResponseEntity.ok().body(devolutivaSalva);
	}
	
}
