package uea.cautela_drive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.cautela_drive.models.Veiculo;
import uea.cautela_drive.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo criar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public List<Veiculo> listar() {
		return veiculoRepository.findAll();
	}

	public Veiculo buscarPorCodigo(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
		return veiculo;
	}

	public Veiculo atualizar(Long id, Veiculo veiculo) {
		Veiculo veiculoSalvo = veiculoRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(veiculo, veiculoSalvo, "id");
		return veiculoRepository.save(veiculoSalvo);
	}

	public void excluir(Long id) {
		veiculoRepository.deleteById(id);
	}
}
