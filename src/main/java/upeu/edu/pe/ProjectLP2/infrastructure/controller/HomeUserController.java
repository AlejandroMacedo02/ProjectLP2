/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ProjectLP2.app.repository.UserRepository;
import upeu.edu.pe.ProjectLP2.app.service.ProductService;
import upeu.edu.pe.ProjectLP2.app.service.UserService;

/**
 *
 * @author alejandromacedop
 */

@Controller
@RequestMapping("/homeuser")
public class HomeUserController {
 
    
    private final ProductService productService;
    private final UserService userService;
    private final UserRepository userRepository;

    public HomeUserController(ProductService productService, UserService userService, UserRepository userRepository) {
        this.productService = productService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

   @GetMapping
    public String home(Model model){
        
       
        model.addAttribute("products", productService.getProducts());
        return "user/user";
        
    }
    
}
