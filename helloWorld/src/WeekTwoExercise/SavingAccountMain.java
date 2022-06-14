package WeekTwoExercise;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class SavingAccountMain {
    public static void main(String[] args) throws ParseException {
//        SavingAccount savingAccount = new SavingAccount();
        List<SavingAccount> listSavingAcc = new ArrayList<>();

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
                    inputAccount(listSavingAcc);
                    break;
                case 2:
                    showAccount(listSavingAcc);
                    break;
                case 3:
                    for (int i = 0; i < listSavingAcc.size(); i++) {
                        listSavingAcc.get(i).withdrawProfit();
                    }
                    break;
                case 4:
                    for (int i = 0; i < listSavingAcc.size(); i++) {
                        listSavingAcc.get(i).withdrawPartialy();
                    }
                    break;
                case 5:
                    for (int i = 0; i < listSavingAcc.size(); i++) {
                        listSavingAcc.get(i).totallyWithdraw();
                    }
                    break;
            }
            System.out.println("Ban co muon tiep tuc khong, Y de tiep tuc else khong: ");
            Scanner next = new Scanner(System.in);
            isContinue = next.nextLine().equalsIgnoreCase("Y");
        }
//        listSavingAcc.add(savingAccount);
//        savingAccount.calculateSendingDate();
//        savingAccount.calculateProfitAmount();
//        savingAccount.withdraw()Profit();
//        savingAccount.withdrawPartialy();
        //savingAccount.totallyWithdraw();
    }

    public static void inputAccount(List<SavingAccount> savingAccountList) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("So luong tai khoan muon them: ");
        int quantityAccount = scanner.nextInt();
        for (int i = 0; i < quantityAccount; i++) {
            SavingAccount savingAccount = new SavingAccount();
            savingAccount.appendNewAcc();
            savingAccountList.add(savingAccount);
            System.out.println("Da them tai khoan " + savingAccount.getAccountName() + " vao danh sach");
        }
        System.out.println("So luong tai khoan da them " + savingAccountList.size());

    }

    public static void showAccount(List<SavingAccount> savingAccountList) {
        for (int i = 0; i < savingAccountList.size(); i++) {
            System.out.println("Thong tin tai khoan thu ");
            savingAccountList.get(i).displayInfo();
        }
    }
}
