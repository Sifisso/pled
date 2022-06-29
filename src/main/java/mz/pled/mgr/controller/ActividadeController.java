package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.Actividade;
import mz.pled.mgr.repository.ActividadeRepository;

@Controller
public class ActividadeController {
	
	@Autowired
    private ActividadeRepository actividadeRepository;

    @GetMapping("/view/actividade")
    public String viewActividade(ModelMap model){
    	
    	model.addAttribute("actividade", new Actividade());

        return "/parametrizacao/actividade/cadastrar";
    }
    
    @PostMapping("cadastrar/actividade")
    public String gravarActividade(Actividade actividade) {

    	actividadeRepository.save(actividade);

        return "redirect:/listar/actividade";
    }

    
    @GetMapping("/listar/actividade")
    public String listarActividade(ModelMap model){
    	model.addAttribute("actividades", actividadeRepository.findAll());

        return "/parametrizacao/actividade/listar";
    }
    
    
    @PostMapping("/editar/actividade") 
	  public String editarActividade(Actividade actividade) {
	  
    	actividadeRepository.save(actividade);
		  
		  
    	return "redirect:/listar/actividade"; 
	  }
	 
	  
	  @GetMapping("/editar/actividade/{id}") 
	  public String vistaEditaActividade(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("actividade", actividadeRepository.findById(id));
	  
	  return "parametrizacao/actividade/editar"; 
	  }
	  

}


