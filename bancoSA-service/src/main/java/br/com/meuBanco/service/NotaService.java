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

import br.com.meuBanco.model.TbNota;
import br.com.meuBanco.repository.NotaRepository;
import br.com.meuBanco.response.ResponseModel;
 

 
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class NotaService {
 
	@Autowired
	private NotaRepository notaRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param nota
	 * @return
	 */
	@RequestMapping(value="/nota", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbNota tbNota){
 
		
 
		try {
 
			this.notaRepository.save(tbNota);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA NOTA
	 * @param nota
	 * @return
	 */
	@RequestMapping(value="/nota", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbNota tbNota){
 
		try {
 
			this.notaRepository.save(tbNota);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS NOTAS
	 * @return
	 */
	@RequestMapping(value="/nota", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbNota> consultar(){
 
		return this.notaRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA NOTA PELO ID
	 * @param idNotas
	 * @return
	 */
	@RequestMapping(value="/nota/{idNotas}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbNota buscar(@PathVariable("idNotas") Integer idNotas){
 
		return this.notaRepository.findOne(idNotas);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param idNotas
	 * @return
	 */
	@RequestMapping(value="/nota/{idNotas}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idNotas") Integer idNotas){
 
		TbNota tbNota = notaRepository.findOne(idNotas);
 
		try {
 
			notaRepository.delete(tbNota);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}