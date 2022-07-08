package mz.pled.mgr.controller;

import mz.pled.mgr.domain.ProvinciaProjecto;
import mz.pled.mgr.domain.User;
import mz.pled.mgr.domain.UserProvinciaProjecto;
import mz.pled.mgr.repository.*;
import mz.pled.mgr.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProjectoRepository projectoRepository;

    @Autowired
    ProvinciaProjectoRepository provinciaProjectoRepository;

    @Autowired
    private EmailService emailService;

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

    @GetMapping("/projectos/usuarios/{id}")
    public String projectosUtilizador(@PathVariable("id") Long id, ModelMap model){

        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("userid", id);
        model.addAttribute("perfils", roleRepository.findAll());
        model.addAttribute("projectos", projectoRepository.findAll());
        model.addAttribute("niveis", responsabilidadeRepository.findAll());
        model.addAttribute("projectosusers", userProvinciaProjectoRepository.buscarUserProjectosProvincias(id));

        return "usuarios/projectos";
    }

    @GetMapping("/projectos/provincias/{proj}/{user}")
    public String projectosProvincia(@PathVariable("proj") Long proj, @PathVariable("user") Long user, ModelMap model){

        model.addAttribute("user", user);
        model.addAttribute("projecto",projectoRepository.buscarPorId(proj));
        model.addAttribute("userprojprov", new UserProvinciaProjecto());
        model.addAttribute("projectosProvincias", provinciaProjectoRepository.buscarPorProjecto(proj));


        return "usuarios/provinciaProjectos";
    }

    @GetMapping("/user/provincias/{proj}/{user}")
    public String userprojectosProvincia(@PathVariable("proj") Long proj, @PathVariable("user") Long user, ModelMap model){

        model.addAttribute("user", user);
        model.addAttribute("projecto",projectoRepository.buscarPorId(proj));
        model.addAttribute("userprojprov", new UserProvinciaProjecto());
        model.addAttribute("projectosProvincias", provinciaProjectoRepository.buscarPorProjecto(proj));
        model.addAttribute("projectosusers", userProvinciaProjectoRepository.buscarUserProjectosProvincias(user));


        return "usuarios/userProvincias";
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
    public String cadastrarUsuarios(ModelMap model, User user,RedirectAttributes attr, UserProvinciaProjecto userProvinciaProjecto){

        try{

            int codigo = ThreadLocalRandom.current().nextInt(999, 10000);

            user.setPassword(passwordEncoder.encode(""+codigo));

            if(userRepository.save(user)!=null){

                model.addAttribute("sucesso","Utilizador Cadastrado com sucesso!");
                attr.addAttribute("sucesso","Utilizador Cadastrado com sucesso!");
                System.out.println("Utilizador Cadastrado com sucesso!");

                String descricao = "Caro(a) "+user.getNome()+" foi registado com utilizador "+user.getUsername()+" a sua senha é: "+codigo;
                String nome = "Usuario Cadastrado com sucesso";
                String destino = user.getEmail();
                String assunto = "Usuario Cadastrado";

                emailService.enviarEmail(descricao, nome, destino, assunto);

            }else{
                model.addAttribute("erro","Erro ao Cadastrar!");
                attr.addAttribute("erro","Erro ao Cadastrar!");
                System.out.println("Erro ao Cadastrar!");
            }

        }catch(Exception ex){
               model.addAttribute("excessao","Ocorreu o seguinte erro: "+ex.getMessage());
               attr.addAttribute("excessao","Ocorreu o seguinte erro: "+ex.getMessage());
               System.out.println("Ocorreu o seguinte erro: "+ex.getMessage());
        }

        //return "redirect:/listar/usuarios";
        return "usuarios/cadastrar";
    }
    @PostMapping("/user/projecto/provincia")
    public String userProjectoProvincia(UserProvinciaProjecto userProvinciaProjecto, RedirectAttributes attr, @RequestParam("user") long user){

       // for(long projecto: projectos) {

            //ProvinciaProjecto provinciaProjecto = projectoService.buscarPorId(projecto);
            User user1 = userRepository.buscarPorId(user);

           // userProvinciaProjecto.setProvinciaProjecto(provinciaProjecto);
            userProvinciaProjecto.setUser(user1);
            userProvinciaProjectoRepository.save(userProvinciaProjecto);

        //}

        //return "redirect:/listar/usuarios";
        return "redirect:/projectos/usuarios/"+user;
    }

    @GetMapping("/provincia/projectos/{id}")
    public String apagarProvinciaProjectos(@PathVariable("id") Long id){

        UserProvinciaProjecto idUserProvProj = userProvinciaProjectoRepository.buscarPorId(id);
        userProvinciaProjectoRepository.delete(idUserProvProj);

        return "redirect:/projectos/usuarios/"+idUserProvProj.getUser().getId();
    }
    @GetMapping("/apagar/usuarios/{id}")
    public String apagarUtilizador(@PathVariable("id") Long id){

        User user1 = userRepository.buscarPorId(id);
        userRepository.delete(user1);

        return "redirect:/listar/usuarios";
    }


}
