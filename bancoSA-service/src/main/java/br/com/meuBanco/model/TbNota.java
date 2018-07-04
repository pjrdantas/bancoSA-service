package br.com.meuBanco.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the tb_notas database table.
 * 
 */
@Entity
@Table(name="tb_notas")
public class TbNota {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_notas", unique=true, nullable=false)
	private int idNotas;

	@Column(name="tb_notas_valor", nullable=false, precision=10, scale=2)
	private BigDecimal tbNotasValor;

	

	public int getIdNotas() {
		return this.idNotas;
	}

	public void setIdNotas(int idNotas) {
		this.idNotas = idNotas;
	}

	public BigDecimal getTbNotasValor() {
		return this.tbNotasValor;
	}

	public void setTbNotasValor(BigDecimal tbNotasValor) {
		this.tbNotasValor = tbNotasValor;
	}

}