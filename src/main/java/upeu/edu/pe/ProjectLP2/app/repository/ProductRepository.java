package upeu.edu.pe.ProjectLP2.app.repository;

import java.util.List;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public interface ProductRepository {

    //LISTA DE TODOS LOS PRODUCTOS
    Iterable<ProductEntity> getProducts();

    //LISTA DE PRODUCTOS POR USUARIO
    Iterable<ProductEntity> getProductsByUser(UserEntity user);

    ProductEntity getProductById(Integer id);

    ProductEntity saveProduct(ProductEntity product);

    void deleteProductById(Integer id);
}
