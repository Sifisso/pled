package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.pled.mgr.domain.Projecto;
import mz.pled.mgr.domain.ProvinciaProjecto;
import mz.pled.mgr.repository.ProjectoRepository;
import mz.pled.mgr.repository.ProvinciaProjectoRepository;
import mz.pled.mgr.repository.ProvinciaRepository;

@Controller
public class ProjectoController {
	
	@Autowired
    private ProjectoRepository projectoRepository;

	@Autowired
    private ProvinciaRepository provinciaRepository;
	
	@Autowired
    private ProvinciaProjectoRepository provinciaProjectoRepository;

    @GetMapping("/view/projecto")
    public String viewProjecto(ModelMap model){
    	
    	model.addAttribute("projecto", new Projecto());

        return "/parametrizacao/projecto/cadastrar";
    }
    
    @PostMapping("/cadastrar/projecto")
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
	  
	  
	  @GetMapping("/actividade/registar/{id}")
	   public String vistaConfigActividade(@PathVariable("id") Long id, ModelMap model) {
		  
		  model.addAttribute("projecto",projectoRepository.findById(id));
		  
		  return "parametrizacao/actividade/config";
		  
		  
	  }
	  
	  @GetMapping("/provincia/registarr/{id}")
	    public String viewRegistarProjectoDaProvincia(@PathVariable("id") long id, ModelMap model){
		  //	model.addAttribute("projecto", new Projecto());
		  
		  	model.addAttribute("projecto",projectoRepository.findById(id));
		  	model.addAttribute("projectoid", id);
		  	model.addAttribute("provinciaprojectos",provinciaProjectoRepository.buscarPorProjecto(id));
		  	model.addAttribute("projectoprovincias",new ProvinciaProjecto());
		  	model.addAttribute("projectoNome",projectoRepository.buscarPorIdProjecto(id));
		  	
		  	model.addAttribute("provincias",provinciaRepository.buscarTodosSemSelecao(id));
		  	//model.addAttribute("provincias", projectoRepository.buscarTodosSemSelecao(id));
		  	
	        return "/parametrizacao/projecto/addProjecto";
	        
	    }
	  
	  @GetMapping("/provincia/apagar/{id}")
	    public String apagarProjectoProvincia(@PathVariable("id") Long id, ModelMap model) {

	        
		  ProvinciaProjecto projecto1 = provinciaProjectoRepository.buscarPorID(id);
	      Projecto projecto2 = projecto1.getProjecto();
	      provinciaProjectoRepository.deleteById(projecto1.getId());
	      
	      return "redirect:/provincia/registarr/"+projecto2.getId();

	    }
	  
	 /* @GetMapping("/provincia/registar/{id}")
	   public String vistaRegistarProvincia(@PathVariable("id") Long id, ModelMap model) {
		  
		  model.addAttribute("projecto",projectoRepository.findById(id));
		  
		  model.addAttribute("provinciaprojectos",provinciaProjectoRepository.buscarPorProjecto(id));
		  model.addAttribute("provinciaProjecto",new ProvinciaProjecto());
		  model.addAttribute("projectos", projectoRepository.buscarTodosSemSelecao(id));
		  model.addAttribute("projectoid", id);
		  
		  return "redirect:/provincia/registarr/"+id;
		  
	  }*/
	  
	  @PostMapping("/cadastrarr/provincia")
	    public String provinciaProjecto (ProvinciaProjecto provinciaProjecto,@RequestParam("projecto") long projecto, RedirectAttributes attr) {

	      Projecto projecto1 = projectoRepository.buscarPorIdProjecto(projecto);
	      provinciaProjecto.setProjecto(projecto1);
	      provinciaProjectoRepository.save(provinciaProjecto);
	      
	        return "redirect:/provincia/registarr/"+projecto1.getId();
	    }

	  
	  
	  
	 
	  
	  

}


