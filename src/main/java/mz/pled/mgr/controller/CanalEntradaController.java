package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.CanalEntrada;
import mz.pled.mgr.domain.Categoria;
import mz.pled.mgr.repository.CanalEntradaRepository;

@Controller
public class CanalEntradaController {
	
	@Autowired
    private CanalEntradaRepository canalEntradaRepository;

    @GetMapping("/view/canal")
    public String viewCadastrarCanal(ModelMap model){
    	
    	model.addAttribute("canalEntrada", new CanalEntrada());

        return "/parametrizacao/canalEntrada/cadastrar";
    }
    
    @PostMapping("cadastrar/canal")
    public String gravarCanal(CanalEntrada canalEntrada) {

    	canalEntradaRepository.save(canalEntrada);

        return "redirect:/listar/canal";
    }

    
    @GetMapping("/listar/canal")
    public String listarCanal(ModelMap model){
    	model.addAttribute("canaisDeEntrada", canalEntradaRepository.findAll());

        return "/parametrizacao/canalEntrada/listar";
    }
    
    
    @PostMapping("/editar/canal") 
	  public String editar(CanalEntrada canalEntrada) {
	  
    	canalEntradaRepository.save(canalEntrada);
		  
		  
    	return "redirect:/listar/canal"; 
	  }
	 
	  
	  @GetMapping("/editar/canal/{id}") 
	  public String vistaEditarCanal(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("canalEntrada", canalEntradaRepository.findById(id));
	  
	  return "parametrizacao/canalEntrada/editar"; 
	  }

}


