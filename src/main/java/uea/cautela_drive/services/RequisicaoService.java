package uea.cautela_drive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.cautela_drive.models.Coordenador;
import uea.cautela_drive.models.Requisicao;
import uea.cautela_drive.repositories.CoordenadorRepository;
import uea.cautela_drive.repositories.RequisicaoRepository;

@Service
public class RequisicaoService {
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	
	@Autowired
	private CoordenadorRepository coordenadorRepository;
	
	public Requisicao criar(Requisicao requisicao) {
		Coordenador coordenador = coordenadorRepository.findById(requisicao.getCoordenador().getId()).orElseThrow();
		return requisicaoRepository.save(requisicao);
	}
	
	public List<Requisicao> listar(){
		return requisicaoRepository.findAll();
	}
	
	public Requisicao buscarPorCodigo(Long id) {
		Requisicao requisicao = requisicaoRepository.findById(id).orElseThrow();
		return requisicao;
	}
	
	public void excluir(Long id) {
		requisicaoRepository.deleteById(id);
	}
	
	public Requisicao atualizar(Long id, Requisicao requisicao) {
		Requisicao requisicaoSalva = requisicaoRepository.findById(id).orElseThrow();
		Coordenador coordenador = coordenadorRepository.findById(requisicao.getCoordenador().getId()).orElseThrow();
		BeanUtils.copyProperties(requisicao, requisicaoSalva, "id");
		return requisicaoRepository.save(requisicaoSalva);
	}
}
