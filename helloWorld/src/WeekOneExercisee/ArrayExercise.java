package WeekOneExercisee;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/*      Tính trung bình cộng các số lẻ ở vị trí chẵn
        Tìm số lớn nhất trong mảng vừa nhập
        Tìm vị trí các số nhỏ nhất trong mảng
        Đếm các số chính phương có trong mảng
        Hiện thị các số nguyên tố có trong mảng lên màn hình
        Thay thế các phần tử âm có trong mảng bằng giá trị 0
        Xóa các phần tử âm có trong mảng
        Sắp xếp mảng đã nhập theo thứ tự tăng dần*/
public class ArrayExercise {

//    public static boolean checkSoNT(int a) {
//        if (a < 2) {
//            return false;
//        } else if (a == 2) {
//            return true;
//        } else if (a > 2) {
//            for (int i = 2; i < a; i++) {
//                if (a % i == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so luong phan tu mang: ");
        int n = scanner.nextInt();
        int[] pointArray = new int[n];
        System.out.println("Nhap cac phan tu cua mang la: ");
        for (int i = 0; i < n; i++) {
            pointArray[i] = scanner.nextInt();
        }
        System.out.print("Cac phan tu cua mang la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(pointArray[i] + " ");
        }
        //----------------------------
//        int sum = 0;
//        int count = 0;
//        System.out.print("\nTrung binh cong cac so le o vi tri chan la: ");
//        for (int i = 0; i < n; i = i + 2) {
//            if (pointArray[i] % 2 != 0) {
//                count++;
//                sum += pointArray[i];
//            }
//        }
//        System.out.println(sum / count);
        //-------------------------
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            if (max <= pointArray[i]) {
//                max = pointArray[i];
//            }
//        }
//        System.out.println("So lon nhat trong day so la: " + max);

//        -------------------------
        int min = pointArray[0];
        for (int i = 0; i < n; i++) {
            if(min >= pointArray[i]){
                min = pointArray[i];
            }
        }

        System.out.println("\nSo nho nhat trong day so la: " + min);
        System.out.println("Cac vi tri chua so nho nhat cua mang la: ");
        for (int i = 0; i < n; i++) {
            if (pointArray[i] == min) {
                System.out.print(i + " ");
            }
        }
//        --------------------------
//        int count2 = 0;
//        for (int i = 0; i < n; i++) {
//            if(sqrt(pointArray[i]) == (int)sqrt(pointArray[i])){
//                count2 ++;
//            }
//        }
//        System.out.println("\nCac so chinh phuong co trong mang la: "+count2);
////          -------------------------
//        ArrayList<String> arrayList2 = new ArrayList<String>();
//        for (int i = 0; i < n; i++) {
//            if(n % (i+1) ==0){
//                break;
//            }else{
//                arrayList2.add(String.valueOf(pointArray[i]));
//            }
//        }
//        System.out.println("\nCac so nguyen to trong mang la: "+arrayList2);
//        -------------------------
//        ArrayList<String> arrayList3 = new ArrayList<String>();
//        for (int i = 0; i < n; i++) {
//            if(pointArray[i] < 0){
//                pointArray[i] = 0;
//            }
//            arrayList3.add(String.valueOf(pointArray[i]));
//        }
//        System.out.println("Mang sau khi thay the cac gia tri am la: "+arrayList3);
//        -----------------------------
//        ArrayList<String> arrayList4 = new ArrayList<String>();
//        for (int i = 0; i < n; i++) {
//            if(pointArray[i] >= 0) {
//                arrayList4.add(String.valueOf(pointArray[i]));
//            }
//        }
//        System.out.println("\nMang sau khi remove cac phan tu am la: "+arrayList4);
        int count = 0;
        for (int i = 0; i < pointArray.length; i++) {
            if (pointArray[i] >= 0) {
                count++;
            }
        }
        int[] newArray = new int[count];
        int size = 0;
        for (int i = 0; i < pointArray.length; i++) {
            if (pointArray[i] >= 0) {
                newArray[size] = pointArray[i];
                size++;
            }
        }
        System.out.println("\nMang sau khi remove cac phan tu am la: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
//           ----------------------------
//        System.out.print("\nSo nguyen to trong mang la: ");
//        for (int i = 0; i< n;i++) {
//            if (checkSoNT(pointArray[i]) == true) {
//                System.out.print(pointArray[i]+ " ");
//            }
//        }
//        ---------------------
//        int temp;
//        for (int i = 0; i < n; i++) {
//            for (int j = n - 1; j > i; j--) {
//                if (pointArray[j] < pointArray[j - 1]) {
//                    temp = pointArray[j];
//                    pointArray[j] = pointArray[j - 1];
//                    pointArray[j - 1] = temp;
//                }
//            }
//        }
//        System.out.print("\nMang sap xep tang dan la: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(pointArray[i]+" ");
//        }
    }
}
