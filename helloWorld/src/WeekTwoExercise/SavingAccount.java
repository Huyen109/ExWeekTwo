package WeekTwoExercise;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SavingAccount {

    private String accountNumber;
    private String accountName;
    private int principalAmount;
    private int profitAmount;
    private String sendingDays;
    private float rateDay;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(int principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getProfitAmount() {
        return profitAmount;
    }

    public void setProfitAmount(int profitAmount) {
        this.profitAmount = profitAmount;
    }

    public String getSendingDays() {
        return sendingDays;
    }

    public void setSendingDays(String sendingDays) {
        this.sendingDays = sendingDays;
    }

    public float getRateDay() {
        return rateDay;
    }

    public void setRateDay(float rateDay) {
        this.rateDay = rateDay;
    }

    public long calculateSendingDate() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;

        System.out.println("Nhap vao ngay gui co dang dd-mm-yyyy: ");
        sendingDays = scanner.next();


        String endDate = simpleDateFormat.format(currentDate);
        date1 = simpleDateFormat.parse(sendingDays);
        date2 = simpleDateFormat.parse(endDate);

        long getDiff = date2.getTime()-date1.getTime();
        long getDaysToSending =  getDiff / (24 * 60 * 60 * 1000);

        System.out.println("Thoi gian tu ngay gui den ngay hien tai la: "+getDaysToSending);

        return getDaysToSending;
    }

    public int calculateProfitAmount() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so tien goc: ");
        this.principalAmount = scanner.nextInt();
        System.out.println("Nhap vao lai suat: ");
        this.rateDay = scanner.nextFloat();
        profitAmount = (int) (this.principalAmount * this.rateDay * calculateSendingDate());

        return profitAmount;

    }

    public void withdrawProfit() throws ParseException {
        calculateProfitAmount();
        System.out.println("So tien lai nhan duoc la: "+ this.profitAmount);
        Date currentDate = new Date();
        this.sendingDays = SimpleDateFormat.getDateInstance().format(currentDate);
        System.out.println("Ngay gui hien tai la: "+ this.sendingDays);
    }

    public void withdrawPartialy() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao so tien rut tu goc: ");
        int moneyWithdrawal = scanner.nextInt();

        int a = calculateProfitAmount();

        if(moneyWithdrawal <= principalAmount){
            int moneyReceived = moneyWithdrawal + a;
            System.out.println("So tien rut 1 phan tu goc + lai la: " +moneyReceived);
        }

        Date currentDate = new Date();
        this.sendingDays = SimpleDateFormat.getDateInstance().format(currentDate);
        System.out.println("Ngay gui hien tai la: "+ this.sendingDays);

    }

//    public void deposit(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap vao so tien nap them vao tien goc: ");
//        int moneyDeposit = scanner.nextInt();
//
//    }

    public void totallyWithdraw() throws ParseException {
        calculateProfitAmount();
        int moneyReceive = this.profitAmount + this.principalAmount;
        System.out.println("So tien goc va lai nhan duoc la: " + moneyReceive);
        Date currentDate = new Date();
        this.sendingDays = SimpleDateFormat.getDateInstance().format(currentDate);
        System.out.println("Ngay gui hien tai la: "+ this.sendingDays);
        this.principalAmount = 0;
        System.out.println("So tien goc sau khi rut la: "+this.principalAmount);
    }

    public void appendNewAcc() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so tai khoan: ");
        accountNumber = scanner.nextLine();
        System.out.println("Nhap vao ten tai khoan: ");
        accountName = scanner.nextLine();
        System.out.println("Nhap vao tien goc trong tai khoan: ");
        principalAmount = scanner.nextInt();
        calculateSendingDate();
    }
    public void displayInfo(){
        System.out.println("So tai khoan la " + accountNumber
                +"\nTen tai khoan la " +accountName
        + "\nSo tien goc la " + principalAmount
        + "\nNgay bat dau gui la " + sendingDays
        +"\n Lai suat la " + rateDay);
    }
}
