package uea.cautela_drive.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Requisicao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String etinerario;
	private LocalDate dataViagem;
	@ManyToOne
	@JoinColumn(name = "id_coordenador")
	private Coordenador coordenador;

	public Requisicao() {
	}

	public Requisicao(Long id, String descricao, String etinerario, LocalDate dataViagem, Coordenador coordenador) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.etinerario = etinerario;
		this.dataViagem = dataViagem;
		this.coordenador = coordenador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEtinerario() {
		return etinerario;
	}

	public void setEtinerario(String etinerario) {
		this.etinerario = etinerario;
	}

	public LocalDate getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(LocalDate dataViagem) {
		this.dataViagem = dataViagem;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requisicao other = (Requisicao) obj;
		return Objects.equals(id, other.id);
	}

}
