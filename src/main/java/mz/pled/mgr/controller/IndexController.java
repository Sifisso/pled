package mz.pled.mgr.controller;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.AbstractButton;

import mz.pled.mgr.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.pled.mgr.domain.CanalEntrada;
import mz.pled.mgr.domain.Ocorrencia;
import mz.pled.mgr.domain.Provincia;

@Controller
public class IndexController {
	
	@Autowired
    private ProvinciaProjectoRepository provinciaProjectoRepository;
	
	@Autowired
    private PostoAdminitrativoRepository PostoadminitrativoRepository;
	
	@Autowired
    private ProjectoRepository projectoRepository;

    @Autowired
    private CanalEntradaRepository canalEntradaRepository;

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
    	 model.addAttribute("projectos", projectoRepository.findAll());
    	 model.addAttribute("postos", PostoadminitrativoRepository.findAll());

        return "publico/preocupacao";
    }
    
    @GetMapping("/acompanhar/preocupacao")
	public String acompanharOcorrencia(Ocorrencia ocorrencia, @RequestParam long codigo, ModelMap model){
    	
    	
    	ocorrencia = ocorrenciaRepository.findAllByCodigo(codigo);
    	
    	if(ocorrencia==null) {
    		model.addAttribute("error", "Código inexistente");

    		return "publico/acompanhamento";
    	}
    	
    	return "redirect:/ver/detalhe/"+ocorrencia.getId();
    	
    	
    	
	}
    
    
    @GetMapping("/buscar/preocupacao")
	public String bucarPreocupacao(){

    		return "publico/acompanhamento";
    	
    	
	}
    
    @GetMapping("/ajuda")
	public String ajuda(){

    		return "publico/ajuda";
    	
	}
    
    
    @GetMapping("/estatistica")
	public String estatistica(){

    		return "publico/estatistica";
    	
	}
    
    
    @PostMapping("/pesquisar/ocorrencia")
	public String pesquisarOcorrencia(Ocorrencia ocorrencia, @RequestParam long codigo, ModelMap model ) {
    	
    	ocorrencia = ocorrenciaRepository.findAllByCodigo(codigo);

		if(ocorrencia==null) {

			model.addAttribute("error", "Código inexistente");

			return "publico/acompanhamento";
		}
		
		model.addAttribute("ocorrencia", ocorrenciaRepository.buscarPorId(ocorrencia.getId()));
		
		return "redirect:/ver/detalhe/"+ocorrencia.getId();
    	
    }
    
    @GetMapping("/ver/detalhe/{id}")
	public String resolverOcorrencia(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("ocorrencia", ocorrenciaRepository.buscarPorId(id));
		

		return "publico/detalhe";
	}
    
    
    @PostMapping("/precadastrar/ocorrencia")
    public String cadastrarUsuarios(Ocorrencia ocorrencia, CanalEntrada canalEntrada, Provincia provincia, ModelMap model,  @RequestParam("descricaoAnx") String descricaoNexo, RedirectAttributes attr){

        try{

            int codigo = ThreadLocalRandom.current().nextInt(999, 10000);

            CanalEntrada canal = canalEntradaRepository.canalPlataforma();
            
            String codigoo = String.valueOf(codigo);

            ocorrencia.setGrmStamp(codigoo);
            ocorrencia.setCanalEntrada(canal);

            if(ocorrenciaRepository.save(ocorrencia)!=null){

                
                model.addAttribute("ocorrenciaa", ocorrencia.getGrmStamp());
                
                attr.addFlashAttribute("sucesso", "Preocupação submetida com sucesso." +" Anote "
                		+ "o código asseguir para o acompnhamento: "+ocorrencia.getGrmStamp());

    			attr.addFlashAttribute("ocorrenciaa", ocorrenciaRepository.buscarPorId(ocorrencia.getId()));

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
