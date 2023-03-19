package uea.cautela_drive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.cautela_drive.models.Motorista;
import uea.cautela_drive.repositories.MotoristaRepository;

@Service
public class MotoristaService {
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public Motorista criar(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}
	
	public List<Motorista> listar(){
		return motoristaRepository.findAll();
	}
	
	public Motorista buscarPorCodigo(Long id) {
		Motorista motorista = motoristaRepository.findById(id).orElseThrow();
		return motorista;
	}
	
	public Motorista atualizar(Long id, Motorista motorista) {
		Motorista motoristaSalvo = motoristaRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(motorista, motoristaSalvo, "id");
		return motoristaRepository.save(motoristaSalvo);
	}
	
	public void excluir(Long id) {
		motoristaRepository.deleteById(id);
	}
}


