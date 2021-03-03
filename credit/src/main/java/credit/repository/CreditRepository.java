package credit.repository;

import credit.model.Credit;

import java.util.List;

public interface CreditRepository {

    int save(Credit credit);

    List<Credit> findAll();

    int nextID();
}
