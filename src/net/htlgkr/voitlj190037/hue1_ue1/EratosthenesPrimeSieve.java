package net.htlgkr.voitlj190037.hue1_ue1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EratosthenesPrimeSieve implements PrimeSieve{

    private final int MAX;
    private boolean[] isPrime;

    public EratosthenesPrimeSieve(int max) {
        this.MAX = max;
    }

    public void getPrimes() {
        isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);

        //0 und 1 sind keine Primzahlen
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2; i<isPrime.length; i++) {
            if(isPrime[i]) {
                for(int j=i; j<isPrime.length; j=j+i) {
                    if(j!=i) {
                        isPrime[j]=false;
                    }
                }
            }
        }
        printPrimes();
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
}
