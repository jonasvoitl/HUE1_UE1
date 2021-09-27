package net.htlgkr.voitlj190037.hue1_ue1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EratosthenesPrimeSieve implements PrimeSieve{

    private boolean[] isPrime;

    public EratosthenesPrimeSieve(int max) {
        isPrime = new boolean[max];
        Arrays.fill(isPrime, true);

        for(int i=0; i<isPrime.length; i++) {
            if(isPrime[i]==true) {
                for(int j=i; j<isPrime.length; j=j+i) {
                    isPrime[j]=false;
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
        for(int i=0; i<isPrime.length; i++) {
            if(isPrime[i]==true) {
                System.out.println(i+"\n");
            }
        }
    }
}
