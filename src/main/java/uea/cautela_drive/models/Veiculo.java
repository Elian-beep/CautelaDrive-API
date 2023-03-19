package uea.cautela_drive.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private String cor;
	private String categoria;
	private String modelo;
	private LocalDate ultimaInspecao;
	private BigDecimal litrosGasolina;

	public Veiculo() {
	}

	public Veiculo(Long id, String placa, String cor, String categoria, String modelo, LocalDate ultimaInspecao,
			BigDecimal litrosGasolina) {
		super();
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.categoria = categoria;
		this.modelo = modelo;
		this.ultimaInspecao = ultimaInspecao;
		this.litrosGasolina = litrosGasolina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getUltimaInspecao() {
		return ultimaInspecao;
	}

	public void setUltimaInspecao(LocalDate ultimaInspecao) {
		this.ultimaInspecao = ultimaInspecao;
	}

	public BigDecimal getLitrosGasolina() {
		return litrosGasolina;
	}

	public void setLitrosGasolina(BigDecimal litrosGasolina) {
		this.litrosGasolina = litrosGasolina;
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
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

}
