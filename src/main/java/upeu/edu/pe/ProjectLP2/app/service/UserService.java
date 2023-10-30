/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.service;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.ProjectLP2.app.repository.UserRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
   
    public Iterable<UserEntity> getUserEntity(){
        return userRepository.getUserEntity();
    }
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
    
    public Optional<UserEntity> findById(Integer id){
        return userRepository.findById(id);
    }
    
    public UserEntity getUserById(Integer id){
        return userRepository.getUserById(id);
    }
    
    public UserEntity save(UserEntity usuario){
        if (usuario.getId() == null) {
           
            
        return userRepository.save(usuario);
    }else{
         UserEntity userDB = userRepository.getUserById(usuario.getId());
                
         //sino se carga la imagen toma la que se le guardo al registro
        
         usuario.setUserType(userDB.getUserType());
         usuario.setUsername(userDB.getUsername());
         
        return userRepository.save(usuario);
    }
    }
    
    public void deleteUserById(Integer id){
        userRepository.deleteUserById(id);
    }

    public Optional<UserEntity> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
