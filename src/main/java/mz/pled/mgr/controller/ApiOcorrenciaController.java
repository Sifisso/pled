package mz.pled.mgr.controller;

import mz.pled.mgr.domain.PostoAdministrativo;
import mz.pled.mgr.repository.ActividadeRepository;
import mz.pled.mgr.repository.DistritoRepository;
import mz.pled.mgr.repository.PostoAdminitrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import mz.pled.mgr.repository.ProvinciaProjectoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiOcorrenciaController {
	
	@Autowired
    private ProvinciaProjectoRepository provinciaProjectoRepository;

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private PostoAdminitrativoRepository postoAdminitrativoRepository;

    @Autowired
    private ActividadeRepository actividadeRepository;

    @ResponseBody
    @GetMapping("/api/distritos/{id}")
    public String apiBuscarDistritosdeUmaProvincia(@PathVariable("id") long id) {

        Gson gson=new Gson();

        return gson.toJson(distritoRepository.buscarPorIdProvincia(id));

    }

    @ResponseBody
    @GetMapping("/api/postos/{id}")
    public String apiBuscarPostosdeUmDistrito(@PathVariable("id") long id) {

        Gson gson=new Gson();

        return gson.toJson(postoAdminitrativoRepository.buscarPorIdDistrito(id));

    }

    @ResponseBody
    @GetMapping("/api/actividades/{id}")
    public String apiBuscarActividadesdeUmProjecto(@PathVariable("id") long id) {

        Gson gson=new Gson();

        return gson.toJson(actividadeRepository.buscarPorIdProjecto(id));

    }

    @ResponseBody
    @GetMapping("/api/provincias/{id}")
    public String apiBuscarProvinciasdeUmProjecto(@PathVariable("id") long id) {

        Gson gson=new Gson();

        return gson.toJson(provinciaProjectoRepository.buscarPorIdProjecto(id));

    }


}
