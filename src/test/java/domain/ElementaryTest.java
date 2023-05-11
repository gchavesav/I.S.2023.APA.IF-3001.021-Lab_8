package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementaryTest {

    @Test
    void test(){
        int[] a = new int[10_000];
        util.Utility.fill(a, 5000);
        System.out.println("Array content\n" + util.Utility.show(a, 8000, 8200));
        Elementary elementary = new Elementary();
        if (!isSorted(a)){
            elementary.improvedBubbleSort(a);
            System.out.println("\nArray content Impoved bubble sorted\n" + util.Utility.show(a, 8000, 8200));
        }
    }

    private boolean isSorted(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if (util.Utility.compare(a[i], a[i+1]) > 0) return false;
        }
        return true;
    }

}