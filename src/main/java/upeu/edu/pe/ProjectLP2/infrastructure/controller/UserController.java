/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.repository.UserRepository;
import upeu.edu.pe.ProjectLP2.app.service.EmailService;

import upeu.edu.pe.ProjectLP2.app.service.UserService;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserType;

/**
 *
 * @author alejandromacedop
 */
@Controller
@RequestMapping("usuario")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserService userService;

    public UserController(UserRepository userRepository, EmailService emailService, UserService userService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userService = userService;
    }

    

 

    // /usuario/registro
    @GetMapping("/registro")
    public String create() {
        return "user/registro";
    }

    @PostMapping("/save")
    public String save(UserEntity usuario) {
        logger.info("Usuario registro: {}", usuario);

        usuario.setUserType(UserType.USER);
        userRepository.save(usuario);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "user/login";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/acceder")
    public String acceder(UserEntity usuario, HttpSession session) {
        logger.info("Accesos : {}", usuario);
        Optional<UserEntity> user = userRepository.findByEmail(usuario.getEmail());
        logger.info("Usuario de db: {}", user.get());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (user.isPresent()) {
            session.setAttribute("idusuario", user.get().getId());

            if (user.get().getUserType().equals("USER")) {
                return "redirect:/home";
            } else {
                return "redirect:/home";
            }
        } else {
            logger.info("Usuario no existe");
        }

        return "redirect:/";
    }

    @PostMapping("/save-usuario")
    public String saveProduct(UserEntity usuario) {
        userService.save(usuario);
        // Enviar correo electrónico al usuario
        String to = usuario.getEmail();
        String subject = "Correo Creado Exitosamente";
        logger.info("correo enviado: {}", usuario);
        String message = "¡Tu cuenta de usuario ha sido creada exitosamente! Verifica tu correo aquí: https://tudominio.com/verificacion";
        emailService.sendEmail(to, subject, message);
        logger.info("correo enviado: {}", message);
        // Agregar un retraso de 1 segundo (1000 milisegundos) antes de redirigir

        return "redirect:/user/login";
    }
}
