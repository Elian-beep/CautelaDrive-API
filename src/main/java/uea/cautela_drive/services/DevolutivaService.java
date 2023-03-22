package uea.cautela_drive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uea.cautela_drive.dto.ResumoDevolutivaDto;
import uea.cautela_drive.models.Devolutiva;
import uea.cautela_drive.repositories.DevolutivaRepository;
import uea.cautela_drive.repositories.MotoristaRepository;
import uea.cautela_drive.repositories.RequisicaoRepository;
import uea.cautela_drive.repositories.VeiculoRepository;
import uea.cautela_drive.repositories.filters.DevolutivaFilter;

@Service
public class DevolutivaService {
	@Autowired
	private DevolutivaRepository devolutivaRepository;
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	@Autowired
	private MotoristaRepository motoristaRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Page<ResumoDevolutivaDto> resumir(DevolutivaFilter devolutivaFilter, Pageable pageable){
		return devolutivaRepository.filtrar(devolutivaFilter, pageable);
	}
	
	public List<Devolutiva> listar() {
		return devolutivaRepository.findAll();
	}
}
