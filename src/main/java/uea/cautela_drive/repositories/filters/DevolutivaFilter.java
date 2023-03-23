package uea.cautela_drive.repositories.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import uea.cautela_drive.models.enums.Situacao;

public class DevolutivaFilter {
	private Situacao situacao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDevolutivaDe;
	private LocalDate dataDevolutivaAte;

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataDevolutivaDe() {
		return dataDevolutivaDe;
	}

	public void setDataDevolutivaDe(LocalDate dataDevolutivaDe) {
		this.dataDevolutivaDe = dataDevolutivaDe;
	}

	public LocalDate getDataDevolutivaAte() {
		return dataDevolutivaAte;
	}

	public void setDataDevolutivaAte(LocalDate dataDevolutivaAte) {
		this.dataDevolutivaAte = dataDevolutivaAte;
	}

}
