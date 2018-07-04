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

import br.com.meuBanco.model.TbCliente;
import br.com.meuBanco.repository.ClienteRepository;
import br.com.meuBanco.response.ResponseModel;
 

 
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class ClienteService {
 
	@Autowired
	private ClienteRepository clienteRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbCliente tbCliente){
 
		
 
		try {
 
			this.clienteRepository.save(tbCliente);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UM CLIENTE
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbCliente tbCliente){
 
		try {
 
			this.clienteRepository.save(tbCliente);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODOS OS CLIENTES
	 * @return
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbCliente> consultar(){
 
		return this.clienteRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA NOTA PELO ID
	 * @param idCliente
	 * @return
	 */
	@RequestMapping(value="/cliente/{idCliente}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbCliente buscar(@PathVariable("idCliente") Integer idClientes){
 
		return this.clienteRepository.findOne(idClientes);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param idCliente
	 * @return
	 */
	@RequestMapping(value="/cliente/{idCliente}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idCliente") Integer idClientes){
 
		TbCliente tbCliente = clienteRepository.findOne(idClientes);
 
		try {
 
			clienteRepository.delete(tbCliente);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
 
}