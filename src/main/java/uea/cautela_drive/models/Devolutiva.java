package uea.cautela_drive.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import uea.cautela_drive.models.enums.Situacao;

@Entity
public class Devolutiva implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	private LocalDate dataDevolutiva;
	@JoinColumn(name = "id_requisicao")
	@OneToOne
	private Requisicao requisicao;
	@JoinColumn(name = "id_motorista")
	@ManyToOne
	private Motorista motorista;
	@JoinColumn(name = "id_veiculo")
	@ManyToOne
	private Veiculo veiculo;

	public Devolutiva() {
	}

	public Devolutiva(Long id, Situacao situacao, LocalDate dataDevolutiva, Requisicao requisicao, Motorista motorista,
			Veiculo veiculo) {
		super();
		this.id = id;
		this.situacao = situacao;
		this.dataDevolutiva = dataDevolutiva;
		this.requisicao = requisicao;
		this.motorista = motorista;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataDevolutiva() {
		return dataDevolutiva;
	}

	public void setDataDevolutiva(LocalDate dataDevolutiva) {
		this.dataDevolutiva = dataDevolutiva;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
		Devolutiva other = (Devolutiva) obj;
		return Objects.equals(id, other.id);
	}

}
