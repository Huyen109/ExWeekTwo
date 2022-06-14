package WeekTwoExercise;

import java.util.Scanner;

public class Square {
    public float edge;
    public float circum;
    public float area;
    public Square(float edge){
        this.edge = edge;
    }
    public void showEdgeSquare(){
        System.out.println("Canh hinh vuong la: "+edge);
    }
    public void calculateCircumference(){
        circum = edge * 4;
        System.out.println("Chu vi la: "+circum);
    }
    public void calculateArea(){
        area = edge * edge;
        System.out.println("Dien tich la: "+area);
    }
    public void showInfo(){
        showEdgeSquare();
        calculateCircumference();
        calculateArea();
    }
}