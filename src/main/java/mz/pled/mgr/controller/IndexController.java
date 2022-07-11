package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import mz.pled.mgr.domain.Ocorrencia;
import mz.pled.mgr.repository.ProvinciaProjectoRepository;

@Controller
public class IndexController {
	
	@Autowired
    private ProvinciaProjectoRepository provinciaProjectoRepository;

    @GetMapping("/login")
    public String fazerLogin(){

        return "publico/login";
    }

    @GetMapping("/")
    public String leadingPage(){

        return "publico/index";
    }

    @GetMapping("/dashboard")
    public String home(){

        return "dashboard/home";
    }
    
    @GetMapping("/apresentar/preocupacao")
    public String bucarPreocupacao(ModelMap model){
    	
    	 model.addAttribute("ocorrencia", new Ocorrencia());
    	 model.addAttribute("provincias", provinciaProjectoRepository.findAll());
    	 model.addAttribute("projectos", provinciaProjectoRepository.findAll());

        return "publico/preocupacao";
    }
    
    

}
