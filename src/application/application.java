package application;

import entities.Contract;
import entities.Installment;
import entities.services.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Contract contract;
        ContractService contractService = new ContractService();

        System.out.println("Enter with the data's of contract:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        String date = sc.next();
        LocalDate dt = LocalDate.parse(date, dtf);
        System.out.print("Value of the contract: ");
        sc.nextLine();
        double valueContract = sc.nextDouble();
        System.out.println("Enter with the number of installments: ");
        int installmentsQntd = sc.nextInt();
        contract = new Contract(number, dt, valueContract);
        contractService.processContract(contract, installmentsQntd);

        for (int i = 0; i < contract.getInstallments().size(); i++) {
            System.out.println(contract.getInstallments().get(i).getDueDate() + " - "
                    + contract.getInstallments().get(i).getAmount());
        }

    }
}
