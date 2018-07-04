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

import br.com.meuBanco.model.TbConta;
import br.com.meuBanco.repository.ContaRepository;
import br.com.meuBanco.response.ResponseModel;
 

 
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class ContaService {
 
	@Autowired
	private ContaRepository contaRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param conta
	 * @return
	 */
	@RequestMapping(value="/conta", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbConta tbConta){
 
		
 
		try {
 
			this.contaRepository.save(tbConta);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA CONTA
	 * @param conta
	 * @return
	 */
	@RequestMapping(value="/conta", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbConta tbConta){
 
		try {
 
			this.contaRepository.save(tbConta);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS CONTAS
	 * @return
	 */
	@RequestMapping(value="/conta", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbConta> consultar(){
 
		return this.contaRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA NOTA PELO ID
	 * @param idConta
	 * @return
	 */
	@RequestMapping(value="/conta/{idConta}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbConta buscar(@PathVariable("idConta") Integer idConta){
 
		return this.contaRepository.findOne(idConta);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param idConta
	 * @return
	 */
	@RequestMapping(value="/conta/{idConta}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idConta") Integer idConta){
 
		TbConta tbConta = contaRepository.findOne(idConta);
 
		try {
 
			contaRepository.delete(tbConta);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}