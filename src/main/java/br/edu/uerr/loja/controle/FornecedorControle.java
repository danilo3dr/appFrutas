package br.edu.uerr.loja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.uerr.loja.modelo.Produto;
import br.edu.uerr.loja.repositorio.EmpresaRepositorio;
import br.edu.uerr.loja.repositorio.FornecedorRepositorio;
import br.edu.uerr.loja.repositorio.ProdutoRepositorio;

@Controller
public class FornecedorControle {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	EmpresaRepositorio empresaRepositorio;
	
	@Autowired
	FornecedorRepositorio fornecedorRepositorio;
	
	//Listar
	
	@GetMapping("/fornecedor")
	public String ListaFornecedor(Model modelo) {
		modelo.addAttribute("listaFornecedor", fornecedorRepositorio.findAll());
		return "fornecedor";
	}
	
}
