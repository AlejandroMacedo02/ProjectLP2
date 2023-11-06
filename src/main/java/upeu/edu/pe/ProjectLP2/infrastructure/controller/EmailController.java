/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import upeu.edu.pe.ProjectLP2.app.service.EmailService;

/**
 *
 * @author alejandromacedop
 */
@Controller
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-correo")
    public String enviarCorreo(@RequestBody String correoDestino) {
        // Lógica para generar el cuerpo del correo de confirmación
        String cuerpoCorreo = "¡Gracias por registrarte en nuestro sitio! Haz clic en el enlace de confirmación para completar el proceso.";

        // Enviar el correo electrónico de confirmación
        emailService.sendEmail(correoDestino, "Confirmación de Registro", cuerpoCorreo);

        return "Correo electrónico de confirmación enviado con éxito a " + correoDestino;
    }
}
