package entities.services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractService {
        private PaypalService paypalService;

    public void processContract(Contract contract, Integer months) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        double interest = 0;
        double paymentFee = 0;
        double installments = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            LocalDate date = contract.getDate().plusMonths(i);
            paypalService = new PaypalService();
            interest = paypalService.interest(installments, i);
            paymentFee = paypalService.paymentFee(installments + interest);
            double quota = interest + paymentFee + installments;
            contract.addInstallments(new Installment(quota, date));
        }
    }
}
