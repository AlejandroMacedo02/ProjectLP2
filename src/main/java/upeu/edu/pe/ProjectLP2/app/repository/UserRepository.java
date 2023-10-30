package upeu.edu.pe.ProjectLP2.app.repository;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public interface UserRepository {

    List<UserEntity> findAll();
    
    Iterable<UserEntity> getUserEntity();

    Optional<UserEntity> findById(Integer id);
    
    UserEntity getUserById(Integer id);

    UserEntity save(UserEntity usuario);
    
    void deleteUserById(Integer id);

    Optional<UserEntity> findByEmail(String email);
}

