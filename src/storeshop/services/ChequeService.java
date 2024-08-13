package storeshop.services;

import storeshop.model.entities.Cheque;
import storeshop.repositories.ChequeRepository;

import java.util.Collections;
import java.util.List;

public class ChequeService implements AbstractBaseService<Cheque>
{
    @Override
    public Cheque add(Cheque cheque) throws Exception {
        try(ChequeRepository chequeRepository = new ChequeRepository())
        {
            return chequeRepository.add(cheque);
        }
    }

    @Override
    public Cheque update(Cheque cheque) throws Exception {
        try(ChequeRepository chequeRepository = new ChequeRepository())
        {
            return chequeRepository.update(cheque);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try(ChequeRepository chequeRepository = new ChequeRepository())
        {
            chequeRepository.remove(id);
        }
    }

    @Override
    public Cheque findById(long id) throws Exception {
        try(ChequeRepository chequeRepository = new ChequeRepository())
        {
            return chequeRepository.findById(id);
        }
    }

    @Override
    public List<Cheque> findAll() throws Exception {
        try(ChequeRepository chequeRepository = new ChequeRepository())
        {
            return chequeRepository.findAll();
        }
    }
}