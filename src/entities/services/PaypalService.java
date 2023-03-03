package entities.services;

import entities.Installment;

public class PaypalService implements OnlinePaymentService{
    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        double sum = 0;
        for (int i = 0; i < months; i++) {
            sum += amount * 0.01;
        }
        return sum;
    }
}
