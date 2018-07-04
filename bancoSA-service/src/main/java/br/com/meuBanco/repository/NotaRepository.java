package br.com.meuBanco.repository;
 
import java.util.List;
 
import org.springframework.data.repository.Repository;
import br.com.meuBanco.model.TbNota;
 

 
public interface NotaRepository extends Repository<TbNota, Integer> {
 
	void save(TbNota tbNota);
 
	void delete(TbNota tbNota);
 
	List<TbNota> findAll();
 
	TbNota findOne(Integer id);
}