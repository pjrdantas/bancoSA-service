package br.com.meuBanco.repository;
 
import java.util.List;
 
import org.springframework.data.repository.Repository;
import br.com.meuBanco.model.TbConta;
 

 
public interface ContaRepository extends Repository<TbConta, Integer> {
 
	void save(TbConta tbConta);
 
	void delete(TbConta tbConta);
 
	List<TbConta> findAll();
 
	TbConta findOne(Integer id);
}