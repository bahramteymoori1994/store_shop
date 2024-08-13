package storeshop.services;

import storeshop.model.entities.ProductCheque;
import storeshop.repositories.ProductChequeRepository;

import java.util.Collections;
import java.util.List;

public class ProductChequeService implements AbstractBaseService<ProductCheque>
{
    @Override
    public ProductCheque add(ProductCheque productCheque) throws Exception {
        try(ProductChequeRepository productChequeRepository = new ProductChequeRepository())
        {
            return productChequeRepository.add(productCheque);
        }
    }

    @Override
    public ProductCheque update(ProductCheque productCheque) throws Exception {
        try(ProductChequeRepository productChequeRepository = new ProductChequeRepository())
        {
            return productChequeRepository.update(productCheque);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try(ProductChequeRepository productChequeRepository = new ProductChequeRepository())
        {
            productChequeRepository.remove(id);
        }
    }

    @Override
    public ProductCheque findById(long id) throws Exception {
        try(ProductChequeRepository productChequeRepository = new ProductChequeRepository())
        {
            return productChequeRepository.findById(id);
        }
    }

    @Override
    public List<ProductCheque> findAll() throws Exception {
        try(ProductChequeRepository productChequeRepository = new ProductChequeRepository())
        {
            return productChequeRepository.findAll();
        }
    }
}