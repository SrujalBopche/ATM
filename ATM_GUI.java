package Task3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM_GUI {
    private JFrame frame;
    private BankAccount account;

    public ATM_GUI(BankAccount account){
        this.account = account;
        initialize();

    }

    private void  initialize(){
        frame = new JFrame("AMT Interface");
        frame.setSize(200, 200);
        frame.setLayout(new GridLayout(4 ,1 ));

        JButton checkBalance = new JButton("Check Current Balance");
        JButton depositAmount = new JButton("Deposite Amount");
        JButton withdrawAmount = new JButton("Withdraw Amount");
        JButton exit = new JButton("Exit ");

        checkBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame , "Your Current Balance "+account.getBalance());
            }
        });

        depositAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String amt = JOptionPane.showInputDialog(frame , "Enter Amount To Deposit ");
                try {
                    double amount = Double.parseDouble(amt);
                    if(account.deposit(amount)){
                        JOptionPane.showMessageDialog(frame , "Money Succsesfully Deposited "+amount);
                    }else{
                        JOptionPane.showMessageDialog(frame,"Invalid Amount ");
                    }
                } catch (NumberFormatException en) {
                    JOptionPane.showMessageDialog(frame,"Please Check Amount , Invalid Amount");
                }
            }
        });

        withdrawAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String amt = JOptionPane.showInputDialog(frame , "Enter Amount to Withdraw");
                try {
                    double amount = Double.parseDouble(amt);
                    if (account.withdraw(amount)) {
                        JOptionPane.showMessageDialog(frame,"Money Sucsessfullyt Withdraw "+amount);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Amount ");
                    }
                } catch (NumberFormatException en) {
                    JOptionPane.showMessageDialog(frame , "Please Check Amount , Invalid Amount");
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame," Thank You For Using This Application");
                frame.dispose();
            }
        });

        frame.add(checkBalance);
        frame.add(depositAmount);
        frame.add(withdrawAmount);
        frame.add(exit);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100000);
        new ATM_GUI(account);
    }
}
