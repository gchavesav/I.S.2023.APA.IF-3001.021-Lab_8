package domain;

import org.junit.jupiter.api.Test;

public class ElementaryTest {

    @Test
    void test(){
        int a[] = new int[10000];
        util.Utility.fill(a, 500);
        System.out.println(util.Utility.show(a, 8000, 8200));
        Elementary elementary = new Elementary();
        System.out.println("isSorted(a): "+isSorted(a));
        if(!isSorted(a)){
            elementary.improvedBubbleSort(a);
            System.out.println(util.Utility.show(a, 8000, 8200));
        }

    }

    private boolean isSorted(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            if(util.Utility.compare(a[i],a[i+1])>0){
                return false;
            }
        }
        return true;
    }


}