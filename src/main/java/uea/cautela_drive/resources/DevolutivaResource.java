package uea.cautela_drive.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uea.cautela_drive.dto.ResumoDevolutivaDto;
import uea.cautela_drive.models.Devolutiva;
import uea.cautela_drive.repositories.filters.DevolutivaFilter;
import uea.cautela_drive.services.DevolutivaService;



@RestController
@RequestMapping("/devolutivas")
public class DevolutivaResource {
	
	@Autowired
	private DevolutivaService devolutivaService;
	
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
	
}
