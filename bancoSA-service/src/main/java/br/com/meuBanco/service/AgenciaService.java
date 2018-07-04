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

import br.com.meuBanco.model.TbAgencia;
import br.com.meuBanco.repository.AgenciaRepository;
import br.com.meuBanco.response.ResponseModel;
 

 
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class AgenciaService {
 
	@Autowired
	private AgenciaRepository agenciaRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param agencia
	 * @return
	 */
	@RequestMapping(value="/agencia", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbAgencia tbAgencia){
 
		
 
		try {
 
			this.agenciaRepository.save(tbAgencia);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA AGENCIA
	 * @param agencia
	 * @return
	 */
	@RequestMapping(value="/agencia", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbAgencia tbAgencia){
 
		try {
 
			this.agenciaRepository.save(tbAgencia);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS AGENCIAS
	 * @return
	 */
	@RequestMapping(value="/agencia", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbAgencia> consultar(){
 
		return this.agenciaRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA NOTA PELO ID
	 * @param idAgencias
	 * @return
	 */
	@RequestMapping(value="/agencia/{idAgencia}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbAgencia buscar(@PathVariable("idAgencia") Integer idAgencia){
 
		return this.agenciaRepository.findOne(idAgencia);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param idAgencia
	 * @return
	 */
	@RequestMapping(value="/agencia/{idAgencia}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idAgencia") Integer idAgencia){
 
		TbAgencia tbAgencia = agenciaRepository.findOne(idAgencia);
 
		try {
 
			agenciaRepository.delete(tbAgencia);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}