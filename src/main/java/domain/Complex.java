/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class Complex {

    private int recursiveCalls;

    private ArrayList lowUpdate = new ArrayList();
    private ArrayList highUpdate = new ArrayList();

    public void quickSort(int arr[], int low, int high){
        int i=low;
        int j=high;
        int pivot=arr[(low+high)/2];
        do{
            while(arr[i]<pivot) i++;
            while(arr[j]>pivot) j--;
            if(i<=j){
                int aux=arr[i];
                arr[i]=arr[j];
                arr[j]=aux;
                i++;j--;
            }//if
        }while(i<=j);//do

        if(low<j) quickSort(arr,low,j);
        if(i<high) quickSort(arr,i,high);
    }

    public void radixSort(int a[], int n){
        // Find the maximum number to know number of digits
        int m = util.Utility.maxArray(a); //va de 0 hasta el elemento maximo

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(a, n, exp);
    }


    // A function to do counting sort of a[] according to
    // the digit represented by exp.
    private void countSort(int a[], int n, int exp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(a[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[ (a[i]/exp)%10 ] - 1] = a[i];
            count[ (a[i]/exp)%10 ]--;
        }

        // Copy the output array to a[], so that a[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            a[i] = output[i];
    }


    public int getRecursiveCalls() {
        return (recursiveCalls - 1);
    }

    public ArrayList getLowUpdate() {
        return lowUpdate;
    }

    public ArrayList getHighUpdate() {
        return highUpdate;
    }

    public void setRecursiveCalls(int recursiveCalls) {
        this.recursiveCalls = recursiveCalls;
    }

    public void setLowUpdate(ArrayList lowUpdate) {
        this.lowUpdate = lowUpdate;
    }

    public void setHighUpdate(ArrayList highUpdate) {
        this.highUpdate = highUpdate;
    }

    public void mergeSort(int a[], int tmp[], int low, int high){
        //Cada vez que entra a la funcion hace recursividad, al final se le resta 1, ya que no cuenta
        //la primera vez que entra
        recursiveCalls++;

        //Descartar el primero de cada lista al final
        getLowUpdate().add(low);
        getHighUpdate().add(high);


        if(low<high){
            int center = (low+high)/2;
            mergeSort(a,tmp,low,center );
            mergeSort(a,tmp,center+1,high);
            merge(a,tmp,low,center+1,high);
        }//if
    }

    private void merge(int a[], int tmp[], int lowIndex, int highIndex, int endIndex){
        int leftEnd = highIndex - 1;
        int tmpPos = lowIndex;
        int numElements = endIndex - lowIndex + 1;
        while( lowIndex <= leftEnd && highIndex <= endIndex )
            if(a[lowIndex]<=a[highIndex]) {
                tmp[tmpPos++] = a[lowIndex++];
            }
            else{
                tmp[tmpPos++] = a[highIndex++];
            }
        while(lowIndex<= leftEnd) {
            tmp[tmpPos++] = a[lowIndex++];
        }
        while( highIndex <= endIndex ) {
            tmp[tmpPos++] = a[highIndex++];
        }
        for( int i=0;i<numElements;i++,endIndex--)
            a[endIndex] = tmp[endIndex];
    }

    public void shellSort(int a[]) {
        int n = a.length;
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2){
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            int x=1;
            for (int i = gap; i < n; i += 1){
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = a[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap)
                    a[j] = a[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                a[j] = temp;
            }
        }
    }

}
