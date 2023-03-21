package uea.cautela_drive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.cautela_drive.models.Coordenador;
import uea.cautela_drive.repositories.CoordenadorRepository;

@Service
public class CoordenadorService {
	@Autowired
	private CoordenadorRepository coordenadorRepository;

	public Coordenador criar(Coordenador coordenador) {
		return coordenadorRepository.save(coordenador);
	}

	public List<Coordenador> listar() {
		return coordenadorRepository.findAll();
	}

	public Coordenador buscarPorCodigo(Long id) {
		Coordenador coordenador = coordenadorRepository.findById(id).orElseThrow();
		return coordenador;
	}

	public Coordenador atualizar(Long id, Coordenador coordenador) {
		Coordenador coordenadorSalvo = coordenadorRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(coordenador, coordenadorSalvo, "id");
		return coordenadorRepository.save(coordenadorSalvo);
	}

	public void excluir(Long id) {
		coordenadorRepository.deleteById(id);
	}
}
