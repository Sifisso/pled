package mz.pled.mgr.controller;

import mz.pled.mgr.domain.Ocorrencia;
import mz.pled.mgr.domain.User;
import mz.pled.mgr.domain.UserProvinciaProjecto;
import mz.pled.mgr.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class OcorrenciaController {

    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    ProjectoRepository projectoRepository;

    @Autowired
    ProvinciaProjectoRepository provinciaProjectoRepository;

    @Autowired
    ResponsabilidadeRepository responsabilidadeRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CanalEntradaRepository  canalEntradaRepository;

    @Autowired
    TipoAlertaRepository tipoAlertaRepository;

    @Autowired
    TipoOcorrenciaRepository tipoOcorrenciaRepository;


    @GetMapping("/listar/ocorrencias")
    public String listarOcorrencias(ModelMap model){

        model.addAttribute("ocorrencias", ocorrenciaRepository.findAll());

        return "ocorrencia/listar";
    }

    @GetMapping("/view/ocorrencia")
    public String cadastrarOcorrencia(ModelMap model){

        model.addAttribute("ocorrencia", new Ocorrencia());
        model.addAttribute("projectos", projectoRepository.findAll());
        model.addAttribute("provincias", provinciaProjectoRepository.findAll());
        model.addAttribute("tipoOcorrencias", tipoOcorrenciaRepository.findAll());
        model.addAttribute("tipoAlertas", tipoAlertaRepository.findAll());
        model.addAttribute("tipoOcorrencias", tipoAlertaRepository.findAll());
        model.addAttribute("nivelResolucoes", responsabilidadeRepository.findAll());
        model.addAttribute("canaisEntradas", canalEntradaRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "ocorrencia/cadastrar";
    }

    @PostMapping("/cadastrar/ocorrencia")
    public String cadastrarUsuarios(Ocorrencia ocorrencia, RedirectAttributes attr){

        try{

            int codigo = ThreadLocalRandom.current().nextInt(999, 10000);


            if(ocorrenciaRepository.save(ocorrencia)!=null){

                System.out.println("Utilizador Cadastrado com sucesso!");

                attr.addFlashAttribute("sucesso", "Utilizador Cadastrado com sucesso! ");

            }else{
                attr.addFlashAttribute("erro", "Erro ao Cadastrar! ");
                System.out.println("Erro ao Cadastrar!");
            }

        }catch(Exception ex){
            attr.addFlashAttribute("excessao", "Ocorreu o seguinte erro: "+ex.getMessage());
            System.out.println("Ocorreu o seguinte erro: "+ex.getMessage());
        }

        return "redirect:/listar/ocorrencias";

    }

}
