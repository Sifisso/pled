package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mz.pled.mgr.domain.Categoria;
import mz.pled.mgr.domain.TipoAlerta;
import mz.pled.mgr.repository.TipoAlertaRepository;

@Controller
public class TipoAlertaController {
	
	@Autowired
    private TipoAlertaRepository tipoAlertaRepository;
	
	
	@GetMapping("/listar/alerta")
    public String listarTipoAlerta(ModelMap model){
    	model.addAttribute("tipoAlertas", tipoAlertaRepository.findAll());

        return "/parametrizacao/tipoAlerta/listar";
    }


    @GetMapping("/view/alerta")
    public String viewCadastrarTipoAlerta(ModelMap model){
    	
    	model.addAttribute("tipoAlerta", new TipoAlerta());

        return "/parametrizacao/tipoAlerta/cadastrar";
    }
    
    @PostMapping("/cadastrar/tipoAlerta")
    public String gravarTipoAlerta(TipoAlerta tipoAlerta) {

    	tipoAlertaRepository.save(tipoAlerta);

        return "redirect:/listar/alerta";
    }

    
    
    
    @PostMapping("/editar/tipoAlerta") 
	  public String editarTipoAlerta(TipoAlerta tipoAlerta) {
	  
    	tipoAlertaRepository.save(tipoAlerta);
		  
		  
    	return "redirect:/listar/alerta"; 
	  }
	 
	  
	  @GetMapping("/editar/tipoAlerta/{id}") 
	  public String vistaEditarTipoAlerta(@PathVariable("id") Long id, ModelMap model) {
		  
	  model.addAttribute("tipoAlerta", tipoAlertaRepository.findById(id));
	  
	  return "parametrizacao/tipoAlerta/editar"; 
	  }

}


