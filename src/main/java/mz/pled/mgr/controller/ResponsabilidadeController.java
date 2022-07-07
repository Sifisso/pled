package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.Responsabilidade;
import mz.pled.mgr.repository.ResponsabilidadeRepository;

@Controller
public class ResponsabilidadeController {
	
	@Autowired
    private ResponsabilidadeRepository responsabilidadeRepository;

    @GetMapping("/view/responsabilidade")
    public String viewActividade(ModelMap model){
    	
    	model.addAttribute("responsabilidade", new Responsabilidade());

        return "/parametrizacao/responsabilidade/cadastrar";
    }
    
    
    @GetMapping("/listar/responsabilidade")
    public String listarResponsabilidade(ModelMap model){
    	model.addAttribute("responsabilidades", responsabilidadeRepository.findAll());

        return "/parametrizacao/responsabilidade/listar";
    }



    @PostMapping("/cadastrar/responsabilidade")
    public String gravarResponsabilidade(Responsabilidade responsabilidade) {

    	responsabilidadeRepository.save(responsabilidade);

        return "redirect:/listar/responsabilidade";
    }

    
    
    
    
    @PostMapping("/editar/responsabilidade") 
	  public String editarResponsabilidade(Responsabilidade responsabilidade) {
	  
    	responsabilidadeRepository.save(responsabilidade);
		  
		  
    	return "redirect:/listar/responsabilidade"; 
	  }
	 
	  
	  @GetMapping("/editar/responsabilidade/{id}") 
	  public String vistaEditaResponsabilidade(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("responsabilidade", responsabilidadeRepository.findById(id));
	  
	  return "parametrizacao/responsabilidade/editar"; 
	  }
	  

}


