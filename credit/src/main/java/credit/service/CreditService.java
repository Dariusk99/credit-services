package credit.service;

import credit.model.Credit;

import java.util.List;

public interface CreditService {

    boolean addCredit(Credit credit);

    List<Credit> getAll();

    int generateID();
}
