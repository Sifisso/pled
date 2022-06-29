package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.TipoAlerta;
import mz.pled.mgr.domain.TipoOcorrencia;
import mz.pled.mgr.repository.TipoOcorrenciaRepository;

@Controller
public class TipoOcorrenciaController {
	
	@Autowired
    private TipoOcorrenciaRepository tipoOcorrenciaRepository;
	
	
	@GetMapping("/listar/tipoOcorrencia")
    public String listarTipoOcorrencia(ModelMap model){
    	model.addAttribute("tipoOcorrencias", tipoOcorrenciaRepository.findAll());

        return "/parametrizacao/tipoOcorrencia/listar";
    }


    @GetMapping("/view/tipoOcorrencia")
    public String viewCadastrarTipoOcorrencia(ModelMap model){
    	
    	model.addAttribute("tipoOcorrencia", new TipoOcorrencia());

        return "/parametrizacao/tipoOcorrencia/cadastrar";
    }
    
    @PostMapping("/cadastrar/tipoOcorrencia")
    public String gravartipoOcorrencia(TipoOcorrencia tipoOcorrencia) {

    	tipoOcorrenciaRepository.save(tipoOcorrencia);

        return "redirect:/listar/tipoOcorrencia";
    }

    
    
    
    @PostMapping("/editar/tipoOcorrencia") 
	  public String editartipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
	  
    	tipoOcorrenciaRepository.save(tipoOcorrencia);
		  
		  
    	return "redirect:/listar/tipoOcorrencia"; 
	  }
	 
	  
	  @GetMapping("/editar/tipoOcorrencia/{id}") 
	  public String vistaEditartipoOcorrencia(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("tipoOcorrencia", tipoOcorrenciaRepository.findById(id));
	  
	  return "parametrizacao/tipoOcorrencia/editar"; 
	  }

}


