package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Enter numerator: ");
            int numerator = input.nextInt();

            System.out.println("Enter denominator: ");
            int denominator = input.nextInt();

            int result = numerator/denominator;
            System.out.println("Result : "+result);
        }
        catch (ArithmeticException e){
            System.out.println("Error : Divisible by 0 is not allowed");
        }catch (InputMismatchException e){
            System.out.println("Error : Enter only numeric value is allowed ");
        }
    }
}
