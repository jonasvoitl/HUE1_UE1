package net.htlgkr.voitlj190037.hue1_ue1;

import java.util.HashMap;
import java.util.Map;

public class EratosthenesPrimeSieve implements PrimeSieve{

    private final int MAX;
    private int numbers[];
    private boolean isPrime[];

    public EratosthenesPrimeSieve(int max) {
        this.MAX = max;
    }

    public void getPrimes() {
        numbers = new int[MAX];
        isPrime = new boolean[MAX];

        //Array wird mit Nummern befüllt
        for(int i=0; i<numbers.length; i++) {
            numbers[i]=i;
        }
        for(int i=2; i<isPrime.length; i++) {
            if(isPrime[i]==true) {
                for(int j=i; j<numbers.length; j++) {
                    if(numbers[j]%i==0) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        printPrimes();
    }

    @Override
    public boolean isPrime(int p) {
        return false;
    }

    @Override
    public void printPrimes() {
        for(int i=0; i<numbers.length; i++) {
            if(isPrime[i]==true) {
                System.out.println(numbers[i]+"\n");
            }
        }
    }
}
