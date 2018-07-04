package br.com.meuBanco.repository;
 
import java.util.List;
 
import org.springframework.data.repository.Repository;
import br.com.meuBanco.model.TbBanco;
 

 
public interface BancoRepository extends Repository<TbBanco, Integer> {
 
	void save(TbBanco tbBanco);
 
	void delete(TbBanco tbBanco);
 
	List<TbBanco> findAll();
 
	TbBanco findOne(Integer id);
}