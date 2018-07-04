package br.com.meuBanco.repository;
 
import java.util.List;
 
import org.springframework.data.repository.Repository;
import br.com.meuBanco.model.TbMovimentacao;
 

 
public interface MovimentacaoRepository extends Repository<TbMovimentacao, Integer> {
 
	void save(TbMovimentacao tbMovimentacao);
 
	void delete(TbMovimentacao tbMovimentacao);
 
	List<TbMovimentacao> findAll();
 
	TbMovimentacao findOne(Integer id);
}