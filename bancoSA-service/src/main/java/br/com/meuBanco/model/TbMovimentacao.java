package br.com.meuBanco.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_movimentacao database table.
 * 
 */
@Entity
@Table(name="tb_movimentacao")
public class TbMovimentacao {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_movimentacao", unique=true, nullable=false)
	private int idMovimentacao;

	@Column(name="tb_movimenta_credito", nullable=false, precision=11, scale=2)
	private BigDecimal tbMovimentaCredito;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tb_movimentacao_data", nullable=false)
	private Date tbMovimentacaoData;

	@Column(name="tb_movimentacao_debito", nullable=false, precision=11, scale=2)
	private BigDecimal tbMovimentacaoDebito;

	//bi-directional many-to-one association to TbConta
	@ManyToOne
	@JoinColumn(name="tb_conta_id_conta", nullable=false)
	private TbConta tbConta;

	public TbMovimentacao() {
	}

	public int getIdMovimentacao() {
		return this.idMovimentacao;
	}

	public void setIdMovimentacao(int idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public BigDecimal getTbMovimentaCredito() {
		return this.tbMovimentaCredito;
	}

	public void setTbMovimentaCredito(BigDecimal tbMovimentaCredito) {
		this.tbMovimentaCredito = tbMovimentaCredito;
	}

	public Date getTbMovimentacaoData() {
		return this.tbMovimentacaoData;
	}

	public void setTbMovimentacaoData(Date tbMovimentacaoData) {
		this.tbMovimentacaoData = tbMovimentacaoData;
	}

	public BigDecimal getTbMovimentacaoDebito() {
		return this.tbMovimentacaoDebito;
	}

	public void setTbMovimentacaoDebito(BigDecimal tbMovimentacaoDebito) {
		this.tbMovimentacaoDebito = tbMovimentacaoDebito;
	}

	public TbConta getTbConta() {
		return this.tbConta;
	}

	public void setTbConta(TbConta tbConta) {
		this.tbConta = tbConta;
	}

}