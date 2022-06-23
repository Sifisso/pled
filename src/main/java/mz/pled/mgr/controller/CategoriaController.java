package mz.pled.mgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {


    @GetMapping("/view/categoria")
    public String viewCadastrar(){

        return "/parametrizacao/categoria/cadastrar";
    }

    
    @GetMapping("/listar/categoria")
    public String listarCategoria(){

        return "/parametrizacao/categoria/listar";
    }

}


