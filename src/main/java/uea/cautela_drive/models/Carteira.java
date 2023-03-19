package uea.cautela_drive.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Carteira implements Serializable {
	private static final long serialVersionUID = 1L;

	private String categoria;
	private String identificador;
	private LocalDate dataValidade;

	public Carteira() {
	}

	public Carteira(String categoria, String identificador, LocalDate dataValidade) {
		super();
		this.categoria = categoria;
		this.identificador = identificador;
		this.dataValidade = dataValidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

}
