package domain;

import org.junit.jupiter.api.Test;

public class ElementaryTest {
    @Test
    void test() {
        int a[] = new int[10000];
        util.Utility.fill(a, 999);
        System.out.println("Array Content...\n" + util.Utility.show(a, 200));
        Elementary elementary = new Elementary();
        System.out.println(isSorted(a));
        if (!isSorted(a)) {
            elementary.improvedBubbleSort(a);
            System.out.println("\nArray Content Improved Bubble Sort\n" + util.Utility.show(a, 200));
        }
        System.out.println(isSorted(a));
    }

    private boolean isSorted(int[] a) {
        int n = a.length;
        for (int i = 0; i <n-1; i++) {
            if ((util.Utility.compare(a[i], a[i + 1])) > 0)
                return false;
        }
        return true;
    }
}
