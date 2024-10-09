package view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Transaction;
import model.Account;
import java.util.List;

public class InputOutput {

    public static void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Banco Java!");
    }

    public static String requestAccountHolderName() {
        return JOptionPane.showInputDialog("Informe o seu nome:");
    }

    public static int requestAccountType() {
        String[] options = {"Poupança", "Corrente"};
        JComboBox<String> choice = new JComboBox<>(options);
        JOptionPane.showOptionDialog(null, choice, "Tipo de Conta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        return choice.getSelectedIndex();
    }

    public static int showOptions(String[] options) {
        JComboBox<String> choice = new JComboBox<>(options);
        JOptionPane.showOptionDialog(null, choice, "Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        return choice.getSelectedIndex();
    }

    public static void showInvalidValueMessage() {
        JOptionPane.showMessageDialog(null, "O valor informado é inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static double requestDepositInfo() {
        return Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do depósito: ", "Depósito", JOptionPane.QUESTION_MESSAGE));
    }

    public static double requestWithdrawalInfo() {
        return Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do saque:", "Saques", JOptionPane.QUESTION_MESSAGE));
    }

    public static void showSuccessfulWithdrawalMessage() {
        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showFailedWithdrawalMessage() {
        JOptionPane.showMessageDialog(null, "Fundos insuficientes para saque. Limite de saldo negativo atingido.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void displayBalance(double balance) {
        JOptionPane.showMessageDialog(null, "Saldo Atual: R$" + balance, "Saldo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayAccountDetails(String accountDetails) {
        JOptionPane.showMessageDialog(null, accountDetails, "Detalhes da Conta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayFullStatement(List<Transaction> statement) {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : statement) {
            sb.append(transaction.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Extrato Completo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayDepositStatement(List<Transaction> depositStatement) {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : depositStatement) {
            sb.append(transaction.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Extrato de Depósitos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayWithdrawalStatement(List<Transaction> withdrawalStatement) {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : withdrawalStatement) {
            sb.append(transaction.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Extrato de Saques", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void getAccountDetails(Account account) {
        String text = "Titular da Conta: " + account.getAccountHolder() +
        "\nTipo: " + (account.getType() == 1 ? "Poupança" : "Corrente") +
        "\nSaldo: R$" + account.getBalance();

        JOptionPane.showMessageDialog(null, text, "Detalhes da Conta", JOptionPane.INFORMATION_MESSAGE);
    }
}
