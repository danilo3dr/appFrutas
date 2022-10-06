package br.edu.uerr.loja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uerr.loja.modelo.Fornecedor;
import br.edu.uerr.loja.modelo.Produto;
import br.edu.uerr.loja.repositorio.EmpresaRepositorio;
import br.edu.uerr.loja.repositorio.FornecedorRepositorio;
import br.edu.uerr.loja.repositorio.ProdutoRepositorio;

@Controller
public class ProdutoControler {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	EmpresaRepositorio empresaRepositorio;
	
	@Autowired
	FornecedorRepositorio fornecedorRepositorio;
	
	//Listar
	
	@GetMapping("/produtos")
	public String Listaproduto(Model modelo) {
		modelo.addAttribute("listaProdutos", produtoRepositorio.findAll());
		return "produtos";
	}
	
	//From
	@GetMapping("/cadastroProduto")
	public String novoProduto(Model model) {
		Produto produto = new Produto();
		
		model.addAttribute("listaEmpresas", empresaRepositorio.findAll());		
		model.addAttribute("listaFornecedores", fornecedorRepositorio.findAll());
		
		
		model.addAttribute("produto",produto);
		return "formProduto";
	}
	
	//Salvar/Alterar
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(
			@ModelAttribute Produto produto, Model model,
			@RequestParam String nome
		) {
		
		Produto produtos = new Produto();
		produtos.setNome(nome);
		produtoRepositorio.save(produtos);
		return "salvarProduto";
	}
	
	
	//Deletar
	
	@RequestMapping("/deletarProduto/{id}")
	public ResponseEntity<String> deleteProduto(@PathVariable Integer id) {
		
		produtoRepositorio.deleteById(id);
		return ResponseEntity.ok("produto deletado pelo id: "+id);
	}
	
	
	
	
}
