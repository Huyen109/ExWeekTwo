package WeekTwoExercise;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SavingAccountMain {
    static SavingAccount savingAccount = new SavingAccount();
    static Scanner next = new Scanner(System.in);

    static List<SavingAccount> listSavingAcc = new ArrayList<>();

    public static void main(String[] args) throws ParseException {


        boolean isContinue = true;
        while (isContinue){
            System.out.println("Bank Management System\n" +
                    "-------------------------------------\n" +
                    "1. Append new account\n" +
                    "3. Withdraw interest\n" +
                    "4. Partialy withdraw\n" +
                    "5. Totally withdraw\n" +
                    "6. Deposit\n" +
                    "2. Display information");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    inputAccount();
                    break;
                case 2:
                    showAccount(listSavingAcc);
                    break;
                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    String accountNumber = scanner2.nextLine();
                    System.out.println("tai khoan vua nhap la: "+accountNumber);
                    for (SavingAccount account : listSavingAcc) {
                        System.out.println("tai khoan la: "+ account.getAccountNumber());
                        System.out.println("");
                        if ((account.getAccountNumber().equals(accountNumber))) {
                            account.withdrawProfit(account.getSendingDays());
                            break;
                        }
                    }

                    break;
                case 4:
                    Scanner scanner3 = new Scanner(System.in);

                    String accountNumber1 = scanner3.nextLine();
                    for (SavingAccount savingAccount:  listSavingAcc) {
                        if (savingAccount.getAccountNumber().equals(accountNumber1)) {
                            savingAccount.withdrawPartialy(savingAccount.getSendingDays());
                        }
                    }
                    break;
                case 5:
                    Scanner scanner4 = new Scanner(System.in);

                    String accountNumber2 = scanner4.nextLine();
                    for (SavingAccount savingAccount : listSavingAcc) {
                        if(savingAccount.getAccountNumber().equals(accountNumber2)) {
                            savingAccount.totallyWithdraw(savingAccount.getSendingDays());
                        }
                    }
                    break;
            }
            System.out.println("Ban co muon tiep tuc khong, Y de tiep tuc else khong: ");
            isContinue = SavingAccountMain.next.nextLine().equalsIgnoreCase("Y");
        }
//        listSavingAcc.add(savingAccount);
//        savingAccount.calculateSendingDate();
//        savingAccount.calculateProfitAmount();
//        savingAccount.withdraw()Profit();
//        savingAccount.withdrawPartialy();
        //savingAccount.totallyWithdraw();
    }

    public static void inputAccount() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("So luong tai khoan muon them: ");
        int quantityAccount = scanner.nextInt();
        for (int i = 0; i < quantityAccount; i++) {
            SavingAccount account = new SavingAccount();

            account.appendNewAcc();
            listSavingAcc.add(account);
            System.out.println("Da them tai khoan " + account.getAccountName() + " vao danh sach");
        }

        System.out.println("So luong tai khoan da them " + listSavingAcc.size());

    }

    public static void showAccount(List<SavingAccount> savingAccountList) {
        for (int i = 0; i < savingAccountList.size(); i++) {
            System.out.println("Thong tin tai khoan thu ");
            savingAccountList.get(i).displayInfo();
        }
    }

}
