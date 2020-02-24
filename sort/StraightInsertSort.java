package sort;

//直接插入排序，O(n^2)
public class StraightInsertSort {
    public void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int val = a[i];
            while (j >= 0 && val < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 13, 1, 7, 4, 9, 2};
        StraightInsertSort straightInsertSort = new StraightInsertSort();
        straightInsertSort.sort(input);
        for (int a : input) {
            System.out.print(a + " ");
        }
    }
}

