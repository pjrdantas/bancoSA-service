package br.com.meuBanco.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tb_conta database table.
 * 
 */
@Entity
@Table(name="tb_conta")
public class TbConta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_conta", unique=true, nullable=false)
	private int idConta;

	@Column(name="tb_conta_digito", nullable=false)
	private int tbContaDigito;

	@Column(name="tb_conta_numero", nullable=false)
	private int tbContaNumero;

	@Column(name="tb_conta_tipo", nullable=false)
	private int tbContaTipo;

	//bi-directional many-to-one association to TbCliente
	@ManyToOne
	@JoinColumn(name="tb_cliente_id_cliente", nullable=false)
	private TbCliente tbCliente;

	//bi-directional many-to-one association to TbMovimentacao
	@OneToMany(mappedBy="tbConta")
	private List<TbMovimentacao> tbMovimentacaos;

	public TbConta() {
	}

	public int getIdConta() {
		return this.idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public int getTbContaDigito() {
		return this.tbContaDigito;
	}

	public void setTbContaDigito(int tbContaDigito) {
		this.tbContaDigito = tbContaDigito;
	}

	public int getTbContaNumero() {
		return this.tbContaNumero;
	}

	public void setTbContaNumero(int tbContaNumero) {
		this.tbContaNumero = tbContaNumero;
	}

	public int getTbContaTipo() {
		return this.tbContaTipo;
	}

	public void setTbContaTipo(int tbContaTipo) {
		this.tbContaTipo = tbContaTipo;
	}

	public TbCliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(TbCliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public List<TbMovimentacao> getTbMovimentacaos() {
		return this.tbMovimentacaos;
	}

	public void setTbMovimentacaos(List<TbMovimentacao> tbMovimentacaos) {
		this.tbMovimentacaos = tbMovimentacaos;
	}

	public TbMovimentacao addTbMovimentacao(TbMovimentacao tbMovimentacao) {
		getTbMovimentacaos().add(tbMovimentacao);
		tbMovimentacao.setTbConta(this);

		return tbMovimentacao;
	}

	public TbMovimentacao removeTbMovimentacao(TbMovimentacao tbMovimentacao) {
		getTbMovimentacaos().remove(tbMovimentacao);
		tbMovimentacao.setTbConta(null);

		return tbMovimentacao;
	}

}