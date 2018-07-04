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

import br.com.meuBanco.model.TbBanco;
import br.com.meuBanco.repository.BancoRepository;
import br.com.meuBanco.response.ResponseModel;
 

 
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class BancoService {
 
	@Autowired
	private BancoRepository bancoRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param banco
	 * @return
	 */
	@RequestMapping(value="/banco", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbBanco tbBanco){
 
		
 
		try {
 
			this.bancoRepository.save(tbBanco);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UM BANCO
	 * @param banco
	 * @return
	 */
	@RequestMapping(value="/banco", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbBanco tbBanco){
 
		try {
 
			this.bancoRepository.save(tbBanco);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS OS BANCOS
	 * @return
	 */
	@RequestMapping(value="/banco", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbBanco> consultar(){
 
		return this.bancoRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA NOTA PELO ID
	 * @param idBanco
	 * @return
	 */
	@RequestMapping(value="/banco/{idBanco}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbBanco buscar(@PathVariable("idBanco") Integer idBanco){
 
		return this.bancoRepository.findOne(idBanco);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param idBanco
	 * @return
	 */
	@RequestMapping(value="/banco/{idBanco}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idBanco") Integer idBanco){
 
		TbBanco tbBanco = bancoRepository.findOne(idBanco);
 
		try {
 
			bancoRepository.delete(tbBanco);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}