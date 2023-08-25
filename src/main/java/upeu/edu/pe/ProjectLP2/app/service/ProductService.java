/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ProjectLP2.app.service;

import upeu.edu.pe.ProjectLP2.app.repository.ProductRepository;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ProjectLP2.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<ProductEntity> getProducts() {
        return productRepository.getProducts();
    }

    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
        return productRepository.getProductsByUser(user);
    }

    public ProductEntity getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.saveProduct(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
