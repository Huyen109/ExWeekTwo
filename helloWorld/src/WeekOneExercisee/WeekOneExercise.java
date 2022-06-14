package WeekOneExercisee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeekOneExercise {
    public static String[] listName;
    public static void calculateElectricity() {
        System.out.println("\nNhap vao so dien: ");
        Scanner scanner = new Scanner(System.in);
        float numOfElectric = scanner.nextFloat();
        int moneyPay = 0;
        if (0 <= numOfElectric && numOfElectric <= 25) {
            moneyPay = (int) (1000 * numOfElectric);
        }else if (numOfElectric <= 75) {
            moneyPay = (int) (1250 * numOfElectric);
        } else if (numOfElectric <= 150) {
            moneyPay = (int) (1800 * numOfElectric);
        } else if (numOfElectric > 150) {
            moneyPay = (int) (2500 * numOfElectric);
        }
        System.out.println("Electricity bill is: " + moneyPay);
    }
    public static void sortNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao phan tu mang: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Cac phan tu trong mang la: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println("Mang sap sep giam dan la: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
//    public static boolean searchStudent() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap vao so phan tu cua list danh sach sinh vien: ");
//        int n = scanner.nextInt();
//        listName = new String[n];
//        System.out.println("Nhap vao danh sach sinh vien: ");
//        for (int i = 0; i < n; i++) {
//            listName[i] = scanner.nextLine();
//        }
//        System.out.println("Nhap ten sinh vien can tim: ");
//        String searchSV = scanner.nextLine();
//        for (int i = 0; i < listName.length; i++) {
//            if (searchSV.equalsIgnoreCase(listName[i])) {
//                return true;
//            }
//        }
//        return false;
//    }
    public static void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu cua list danh sach sinh vien: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        listName = new String[n];
        System.out.println("Nhap vao danh sach sinh vien: ");
        for (int i = 0; i < n; i++) {
            listName[i] = scanner.nextLine();
        }
        System.out.println("Nhap ten sinh vien can tim: ");
        String searchSV = scanner.nextLine();
        for (int i = 0; i < listName.length; i++) {
            if (searchSV.equalsIgnoreCase(listName[i])) {
                System.out.println("Co ten trong danh sach");
                return;
            }
        }
        System.out.println("ko ten trong danh sach");
    }
    public static void countCharacters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao chuoi ban dau: ");
        String inputBase = scanner.nextLine();
        System.out.println("Nhap vao ki tu can tim kiem: ");
        String inputSignal = scanner.nextLine();
        int count = 0;
        System.out.println("So lan ki tu can tim xuat hien trong chuoi la: ");
        for (int i = 0; i < inputBase.length(); i++) {
            if (inputBase.charAt(i) == inputSignal.charAt(0)) {
                count++;
            }
        }
        System.out.print(count);
    }

    public static void inputArray2(){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[][] = new int[n][n];

        System.out.println("Nhap vao mang: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Mang vua nhap la: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        int sumAr = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if(arr[i][j] == 0){
                    break;
                }
                sumAr += arr[i][j];
            }
        }
        System.out.println("Tong cac so can tim la: "+sumAr);
    }

    public static void main(String[] args) {

//        sortNumber();
////          ------------------
//        countCharacters();
////            ---------------------
//        calculateElectricity();
//            ----------------
//        if (searchStudent()) {
//            System.out.println("Co sinh vien trong danh sach");
//        } else {
//            System.out.println("Khong co sinh vien trong danh sach");
//        }
//        searchStudent();
//
        inputArray2();
    }
}
