package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.Categoria;
import mz.pled.mgr.repository.CategoriaRepository;

@Controller
public class CategoriaController {
	
	@Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping("/view/categoria")
    public String viewCadastrar(ModelMap model){
    	
    	model.addAttribute("categoria", new Categoria());

        return "/parametrizacao/categoria/cadastrar";
    }
    
    @PostMapping("cadastrar/categoria")
    public String gravar(Categoria categoria) {

    	categoriaRepository.save(categoria);

        return "redirect:/listar/categoria";
    }

    
    @GetMapping("/listar/categoria")
    public String listarCategoria(ModelMap model){
    	model.addAttribute("categorias", categoriaRepository.findAll());

        return "/parametrizacao/categoria/listar";
    }
    
    
    @PostMapping("/editar/categoria") 
	  public String editar(Categoria categoria) {
	  
    	categoriaRepository.save(categoria);
		  
		  
    	return "redirect:/listar/categoria"; 
	  }
	 
	  
	  @GetMapping("/editar/categoria/{id}") 
	  public String vistaEditar(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("categoria", categoriaRepository.findById(id));
	  
	  return "parametrizacao/categoria/editar"; 
	  }

}


