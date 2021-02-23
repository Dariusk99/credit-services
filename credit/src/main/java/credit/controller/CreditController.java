package credit.controller;

import credit.model.Credit;
import credit.service.CreditService;

public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    public void CreateCredit(Credit credit) {
        creditService.saveCredit(credit);
    }
}
