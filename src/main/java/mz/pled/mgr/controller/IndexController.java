package mz.pled.mgr.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.pled.mgr.domain.CanalEntrada;
import mz.pled.mgr.domain.Ocorrencia;
import mz.pled.mgr.domain.TipoAlerta;
import mz.pled.mgr.repository.OcorrenciaRepository;
import mz.pled.mgr.repository.ProvinciaProjectoRepository;

@Controller
public class IndexController {
	
	@Autowired
    private ProvinciaProjectoRepository provinciaProjectoRepository;
	

    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

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
    
    
    @PostMapping("/precadastrar/ocorrencia")
    public String cadastrarUsuarios(Ocorrencia ocorrencia, CanalEntrada canalEntrada, @RequestParam("descricaoAnx") String descricaoNexo, RedirectAttributes attr){

        try{

            int codigo = ThreadLocalRandom.current().nextInt(999, 10000);
            
            
            int nivel = ocorrencia.getNivel();
            
            
           if(nivel==0) {
        	   ocorrencia.setNivel(1);
           }


            if(ocorrenciaRepository.save(ocorrencia)!=null){

                System.out.println("Preocupação cadastrada com sucesso!");

                attr.addFlashAttribute("sucesso", "Preocupação cadastrada com sucesso! ");

            }else{
                attr.addFlashAttribute("erro", "Erro ao Cadastrar! ");
                System.out.println("Erro ao Cadastrar!");
            }

        }catch(Exception ex){
            attr.addFlashAttribute("excessao", "Ocorreu o seguinte erro: "+ex.getMessage());
            System.out.println("Ocorreu o seguinte erro: "+ex.getMessage());
        }

        return "redirect:/";

    }
    
    
    
}
