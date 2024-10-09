package controller;

import model.Account;
import view.InputOutput;

public class Controller {
    private Account account = new Account();

    public void displayMenu() {
        InputOutput.showWelcomeMessage();

        String accountHolder = InputOutput.requestAccountHolderName();
        account.setAccountHolder(accountHolder);
        
        int type = InputOutput.requestAccountType();
        account.setType(type);

        while (true) {
            String[] options = {"Depositar", "Sacar", "Mostrar Saldo", "Mostrar Detalhes da Conta", "Mostrar Extrato Completo", "Mostrar Extrato de Depósitos", "Mostrar Extrato de Saques", "Sair"};

            int choice = InputOutput.showOptions(options);
            switch (choice) {
                case 0:
                    double depositAmount = InputOutput.requestDepositInfo();
                    while (depositAmount <= 0) {
                        InputOutput.showInvalidValueMessage();
                    }
                    account.deposit(depositAmount);
                    break;

                case 1:
                    double withdrawalAmount = InputOutput.requestWithdrawalInfo();
                    while (withdrawalAmount <= 0) {
                        InputOutput.showInvalidValueMessage();
                    }
                    Boolean isSuccessful = account.withdraw(withdrawalAmount);
                    if (isSuccessful) {
                        InputOutput.showSuccessfulWithdrawalMessage();
                    } else {
                        InputOutput.showFailedWithdrawalMessage();
                    }
                    break;
                case 2:
                    InputOutput.displayBalance(account.getBalance());
                    break;
                case 3:
                    InputOutput.getAccountDetails(account);
                    break;
                case 4:
                    InputOutput.displayFullStatement(account.getFullStatement());
                    break;
                case 5:
                    InputOutput.displayDepositStatement(account.getDepositStatement());
                    break;
                case 6:
                    InputOutput.displayWithdrawalStatement(account.getWithdrawalStatement());
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
