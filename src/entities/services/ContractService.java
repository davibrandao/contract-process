package entities.services;

import entities.Contract;
import entities.Installment;

public class ContractService {
    public void processContract(Contract contract, Integer months)
    {
        for (int i = 0; i < months; i++) {

            contract.addInstallments(new Installment());
        }
    }
}
