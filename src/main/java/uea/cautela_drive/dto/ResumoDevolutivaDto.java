package uea.cautela_drive.dto;

import java.time.LocalDate;

import uea.cautela_drive.models.enums.Situacao;

public class ResumoDevolutivaDto {
	private Long id;
	private Situacao situacao;
	private LocalDate dataDevolutiva;
	private String motorista;

	public ResumoDevolutivaDto() {
	}

	public ResumoDevolutivaDto(Long id, Situacao situacao, LocalDate dataDevolutiva, String motorista) {
		super();
		this.id = id;
		this.situacao = situacao;
		this.dataDevolutiva = dataDevolutiva;
		this.motorista = motorista;
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

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

}
