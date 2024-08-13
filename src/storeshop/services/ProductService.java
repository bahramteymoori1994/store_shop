package storeshop.services;

import storeshop.model.entities.Product;
import storeshop.model.enums.ProductName;
import storeshop.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;

public class ProductService implements AbstractBaseService<Product>
{
    @Override
    public Product add(Product product) throws Exception {
        try(ProductRepository productRepository = new ProductRepository())
        {
            return productRepository.add(product);
        }
    }

    @Override
    public Product update(Product product) throws Exception {
        try(ProductRepository productRepository = new ProductRepository())
        {
            return productRepository.update(product);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try(ProductRepository productRepository = new ProductRepository())
        {
            productRepository.remove(id);
        }
    }

    @Override
    public Product findById(long id) throws Exception {
        try(ProductRepository productRepository = new ProductRepository())
        {
            return productRepository.findById(id);
        }
    }

    @Override
    public List<Product> findAll() throws Exception {
        try(ProductRepository productRepository = new ProductRepository())
        {
            return productRepository.findAll();
        }
    }

    public Product findByNumber(String productNumber) throws Exception
    {
        try(ProductRepository productRepository = new ProductRepository())
        {
            return productRepository.findByNumber(productNumber);
        }
    }

//    public Product findByName(String productName) throws Exception
//    {
//        try(ProductRepository productRepository = new ProductRepository())
//        {
//            return productRepository.findByName(productName);
//        }
//    }

    public Product findByModel(String model) throws Exception
    {
        try(ProductRepository productRepository = new ProductRepository())
        {
            return productRepository.findByModel(model);
        }
    }
}