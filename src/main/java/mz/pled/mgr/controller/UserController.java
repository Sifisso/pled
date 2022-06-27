package mz.pled.mgr.controller;

import mz.pled.mgr.domain.ProvinciaProjecto;
import mz.pled.mgr.domain.User;
import mz.pled.mgr.domain.UserProvinciaProjecto;
import mz.pled.mgr.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProvinciaProjectoRepository provinciaProjectoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserProvinciaProjectoRepository userProvinciaProjectoRepository;

    @Autowired
    ResponsabilidadeRepository responsabilidadeRepository;

    @GetMapping("/listar/usuarios")
    public String listarUsuarios(ModelMap model){

        model.addAttribute("usuarios", userRepository.findAll());

        return "usuarios/listar";
    }

    @GetMapping("/view/usuarios")
    public String viewCadastrar(ModelMap model){

        model.addAttribute("user", new User());
        model.addAttribute("perfils", roleRepository.findAll());
        model.addAttribute("niveis", responsabilidadeRepository.findAll());
        model.addAttribute("provinciaProjectos", provinciaProjectoRepository.findAll());

        return "usuarios/cadastrar";
    }

    @PostMapping("/cadastrar/usuarios")
    public String cadastrarUsuarios(User user, UserProvinciaProjecto userProvinciaProjecto, @RequestParam("provinciaProjectos") long provinciaProjectos[]){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        for(long projectoP: provinciaProjectos) {

            ProvinciaProjecto projecto1 = provinciaProjectoRepository.buscarPorID(projectoP);

            userProvinciaProjecto.setProvinciaProjecto(projecto1);
            userProvinciaProjecto.setUser(user);
            userProvinciaProjectoRepository.save(userProvinciaProjecto);

        }

        return "redirect:/listar/usuarios";
    }

}
