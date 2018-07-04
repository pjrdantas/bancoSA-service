package br.com.meuBanco.repository;
 
import java.util.List;
 
import org.springframework.data.repository.Repository;
import br.com.meuBanco.model.TbAgencia;
 

 
public interface AgenciaRepository extends Repository<TbAgencia, Integer> {
 
	void save(TbAgencia tbAgencia);
 
	void delete(TbAgencia tbAgencia);
 
	List<TbAgencia> findAll();
 
	TbAgencia findOne(Integer id);
}