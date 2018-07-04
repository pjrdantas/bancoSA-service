package br.com.meuBanco.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meuBanco.model.TbMovimentacao;
import br.com.meuBanco.repository.MovimentacaoRepository;
import br.com.meuBanco.response.ResponseModel;
 

 
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class MovimentacaoService {
 
	@Autowired
	private MovimentacaoRepository movimentacaoRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param movimentacao
	 * @return
	 */
	@RequestMapping(value="/movimentacao", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbMovimentacao tbMovimentacao){
 
		
 
		try {
 
			this.movimentacaoRepository.save(tbMovimentacao);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA MOVIMENTAÇÃO
	 * @param movimentacao
	 * @return
	 */
	@RequestMapping(value="/movimentacao", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbMovimentacao tbMovimentacao){
 
		try {
 
			this.movimentacaoRepository.save(tbMovimentacao);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS MOVIMENTAÇÕES
	 * @return
	 */
	@RequestMapping(value="/movimentacao", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbMovimentacao> consultar(){
 
		return this.movimentacaoRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA NOTA PELO ID
	 * @param idMovimentacao
	 * @return
	 */
	@RequestMapping(value="/movimentacao/{idMovimentacao}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbMovimentacao buscar(@PathVariable("idMovimentacao") Integer idMovimentacao){
 
		return this.movimentacaoRepository.findOne(idMovimentacao);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param idMovimentacao
	 * @return
	 */
	@RequestMapping(value="/movimentacao/{idMovimentacao}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idMovimentacao") Integer idMovimentacao){
 
		TbMovimentacao tbMovimentacao = movimentacaoRepository.findOne(idMovimentacao);
 
		try {
 
			movimentacaoRepository.delete(tbMovimentacao);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}