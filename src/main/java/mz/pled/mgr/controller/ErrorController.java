package mz.pled.mgr.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class ErrorController implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {

        ModelAndView model = new ModelAndView("/error");
        model.addObject("status", status.value());
        switch(status.value()){
            case 404:
                model.addObject("error","Página não Encontrada!!");
                model.addObject("message","O Endereço URL para a página: '"+ map.get("path") + "' Não foi Existe.");
                break;
            case 500:
                model.addObject("error","Ocorreu um erro interno no Servidor!!!");
                model.addObject("message","Ocorreu um erro não esperado, Tente novamente mais tarde.");
                break;
            default:
                model.addObject("error", map.get("error"));
                model.addObject("message", map.get("message"));
                break;
        }
        return model;
    }
}
