package net.htlgkr.voitlj190037.hue1_ue2;

import net.htlgkr.voitlj190037.hue1_ue1.EratosthenesPrimeSieve;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //abfrage nach oberlimit
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

        //der array mit den geraden, natürlichen Zahlen wird angelegt und befüllt
        int[] numbers = new int[(limit/2)-1];
        int n=4; //n muss gerade und größer als 2 sein, daher 4
        for(int i=0; n<=limit; i++) {
            numbers[i]=n;
            n+=2;
        }

        //die Primzahlen werden von der Klasse EratosthenesPrimeSieve geholt
        EratosthenesPrimeSieve eps = new EratosthenesPrimeSieve(limit);
        eps.calcPrimes();
        ArrayList<Integer> primes = eps.getPrimes();

        //summen berechnen
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<primes.size(); j++) {
                if(primes.contains(numbers[i]-primes.get(j))) {
                    System.out.println(numbers[i]+" = "+primes.get(j)+" + "+(numbers[i]-primes.get(j)));
                    break;
                }
            }
        }
    }
}