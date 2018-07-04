package br.com.meuBanco.repository;
 
import java.util.List;
 
import org.springframework.data.repository.Repository;
import br.com.meuBanco.model.TbCliente;
 

 
public interface ClienteRepository extends Repository<TbCliente, Integer> {
 
	void save(TbCliente tbCliente);
 
	void delete(TbCliente tbCliente);
 
	List<TbCliente> findAll();
 
	TbCliente findOne(Integer id);
}