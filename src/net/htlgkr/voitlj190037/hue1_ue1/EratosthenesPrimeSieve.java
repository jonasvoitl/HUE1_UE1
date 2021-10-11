package net.htlgkr.voitlj190037.hue1_ue1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EratosthenesPrimeSieve implements PrimeSieve{

    private final int MAX;
    private boolean[] isPrime;

    public EratosthenesPrimeSieve(int max) {
        this.MAX = max;
    }

    public void calcPrimes() {
        isPrime = new boolean[MAX+1]; //wenn limit 2 ist müssen trotzdem 3 Stellen im array vorhanden sein (0, 1, 2)
        Arrays.fill(isPrime, true);

        //0 und 1 sind keine Primzahlen und werden daher sofort entfernt
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2; i<isPrime.length; i++) {
            if(isPrime[i]) {
                for(int j=i; j<isPrime.length; j+=i) {
                    if(j!=i) { //die Zahl, dessen Vielfachen gestrichen werden, soll nicht aus dem isPrime array entfernt (auf false gesetzt) werden
                        isPrime[j]=false;
                    }
                }
            }
        }
    }

    @Override
    public boolean isPrime(int p) {
        return isPrime[p] ? true : false;
    }

    @Override
    public void printPrimes() {
        System.out.println("Primzahlen:");
        for(int i=0; i<isPrime.length; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public ArrayList<Integer> getPrimes() {
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=0; i<isPrime.length; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
