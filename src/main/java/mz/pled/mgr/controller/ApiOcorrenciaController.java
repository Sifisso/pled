package mz.pled.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import mz.pled.mgr.repository.ProvinciaProjectoRepository;

@Controller
public class ApiOcorrenciaController {
	
	@Autowired
    private ProvinciaProjectoRepository provinciaProjectoRepository;




}
