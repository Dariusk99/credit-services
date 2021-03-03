package credit.service;

import credit.model.Credit;
import credit.repository.CreditRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepositoryImpl creditRepository;

    public CreditServiceImpl(CreditRepositoryImpl creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public boolean addCredit(Credit credit) {
        if (creditRepository.save(credit) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Credit> getAll() {
        return creditRepository.findAll();
    }

    @Override
    public int generateID() {
        return creditRepository.nextID();
    }
}