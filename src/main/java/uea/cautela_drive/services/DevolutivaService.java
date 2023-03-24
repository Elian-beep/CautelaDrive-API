package uea.cautela_drive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uea.cautela_drive.dto.ResumoDevolutivaDto;
import uea.cautela_drive.models.Coordenador;
import uea.cautela_drive.models.Devolutiva;
import uea.cautela_drive.models.Motorista;
import uea.cautela_drive.models.Requisicao;
import uea.cautela_drive.models.Veiculo;
import uea.cautela_drive.models.enums.Situacao;
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

	public Devolutiva criar(Devolutiva devolutiva) {
		Requisicao requisicao = requisicaoRepository.findById(devolutiva.getRequisicao().getId()).orElseThrow();

		if (devolutiva.getSituacao().equals(Situacao.AUTORIZADO)) {
			Motorista motorista = motoristaRepository.findById(devolutiva.getMotorista().getId()).orElseThrow();
			Veiculo veiculo = veiculoRepository.findById(devolutiva.getVeiculo().getId()).orElseThrow();
			return devolutivaRepository.save(devolutiva);
		}
		return devolutivaRepository.save(devolutiva);
	}

	public Page<ResumoDevolutivaDto> resumir(DevolutivaFilter devolutivaFilter, Pageable pageable) {
		if (devolutivaFilter.getSituacao().equals(Situacao.AUTORIZADO)) {
			return devolutivaRepository.filtrarAutorizado(devolutivaFilter, pageable);
		}
		return devolutivaRepository.filtrar(devolutivaFilter, pageable);
	}

	public List<Devolutiva> listar() {
		return devolutivaRepository.findAll();
	}

	public Devolutiva buscarPorId(Long id) {
		Devolutiva devolutiva = devolutivaRepository.findById(id).orElseThrow();
		return devolutiva;
	}

	public void excluir(Long id) {
		devolutivaRepository.deleteById(id);
	}

	public Devolutiva atualizar(Long id, Devolutiva devolutiva) {
		Devolutiva devolutivaSalva = devolutivaRepository.findById(id).orElseThrow();
		Requisicao requisicao = requisicaoRepository.findById(devolutiva.getRequisicao().getId()).orElseThrow();

		if (devolutiva.getSituacao().equals(Situacao.AUTORIZADO)) {
			Motorista motorista = motoristaRepository.findById(devolutiva.getMotorista().getId()).orElseThrow();
			Veiculo veiculo = veiculoRepository.findById(devolutiva.getVeiculo().getId()).orElseThrow();
			return devolutivaRepository.save(devolutiva);
		}
		BeanUtils.copyProperties(devolutiva, devolutivaSalva, "id");
		return devolutivaRepository.save(devolutivaSalva);
	}
}
