package net.htlgkr.voitlj190037.hue1_ue1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int limit = 0;
        do {
            System.out.println("Geben Sie eine Obergrenze ein. Diese muss Element der natürlichen Zahlen sein.");
            try {
                limit = Integer.parseInt(s.nextLine());
                if(limit<4) {
                    throw new IllegalArgumentException();
                }else {
                    break;
                }
            }catch (IllegalArgumentException e) {
                System.out.println("Dies ist ein ungültiger Wert.");
            }
        }while(true);
        EratosthenesPrimeSieve eps = new EratosthenesPrimeSieve(limit);
        eps.calcPrimes();
        eps.printPrimes();
    }
}
