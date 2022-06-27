package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.Projecto;
import mz.pled.mgr.repository.ProjectoRepository;

@Controller
public class ProjectoController {
	
	@Autowired
    private ProjectoRepository projectoRepository;


    @GetMapping("/view/projecto")
    public String viewProjecto(ModelMap model){
    	
    	model.addAttribute("projecto", new Projecto());

        return "/parametrizacao/projecto/cadastrar";
    }
    
    @PostMapping("cadastrar/projecto")
    public String gravarProjecto(Projecto projecto) {

    	projectoRepository.save(projecto);

        return "redirect:/listar/projecto";
    }

    
    @GetMapping("/listar/projecto")
    public String listarProjectk(ModelMap model){
    	model.addAttribute("projectos", projectoRepository.findAll());

        return "/parametrizacao/projecto/listar";
    }
    
    
    @PostMapping("/editar/projecto") 
	  public String editarProjectk(Projecto projecto) {
	  
    	projectoRepository.save(projecto);
		  
		  
    	return "redirect:/listar/projecto"; 
	  }
	 
	  
	  @GetMapping("/editar/projecto/{id}") 
	  public String vistaEditaProjecto(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("projecto", projectoRepository.findById(id));
	  
	  return "parametrizacao/projecto/editar"; 
	  }

}


