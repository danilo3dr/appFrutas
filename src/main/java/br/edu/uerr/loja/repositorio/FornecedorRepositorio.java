
package br.edu.uerr.loja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uerr.loja.modelo.Fornecedor;
import br.edu.uerr.loja.modelo.Produto;

@Repository
public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Integer> {

	//public Empresa save();
	void save(Produto produtos);
}
