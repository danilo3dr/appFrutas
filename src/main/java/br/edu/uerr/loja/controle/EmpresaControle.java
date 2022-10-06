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

import br.edu.uerr.loja.modelo.Empresa;
import br.edu.uerr.loja.modelo.Produto;
import br.edu.uerr.loja.repositorio.EmpresaRepositorio;

@Controller
public class EmpresaControle {

	@Autowired
	EmpresaRepositorio empresaRepositorio;
	
	//listar
	
	@GetMapping("/empresa")
	public String abreEmpresa(Model modelo) {
		modelo.addAttribute("listaEmpresas", empresaRepositorio.findAll());
		return "empresa";
	}
	

	//Deletar
	
	@RequestMapping("/deletarEmpresa/{id}")
	public ResponseEntity<String> deleteEmpresa(@PathVariable Integer id) {
			
		empresaRepositorio.deleteById(id);
		return ResponseEntity.ok("Empresa deletado pelo id: "+id);
	}
	
	//from
	@GetMapping("/cadastroEmpresa")
	public String novoEmpresa(Model model) {
		Empresa empresa = new Empresa();
		
		
		
		model.addAttribute("empresa",empresa);
		return "formEmpresa";
	}
	
	//Salvar/Alterar
	
	@PostMapping("/salvarEmpresa")
	public ResponseEntity<String> salvarEmpresa(
			@ModelAttribute Empresa empresa, Model model,
			@RequestParam String nome,
			@RequestParam String cnpj,
			@RequestParam String responsavel,
			@RequestParam String representante,
			@RequestParam String telefone,
			@RequestParam String email,
			@RequestParam String cep
		) {
			
		Empresa empresas = new Empresa();
		empresas.setNome(nome);
		empresas.setCnpj(cnpj);
		empresas.setResponsavel(responsavel);
		empresas.setRepresentante(representante);
		empresas.setTelefone(telefone);
		empresas.setEmail(email);
		empresas.setCep(cep);
		
		empresaRepositorio.save(empresas);
		return ResponseEntity.ok("empresa Cadastrada");
	}
	
	
	
	
}
