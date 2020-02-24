package sort;

public class QuickSort {
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int loc = partition(a, low, high);
        quickSort(a, low, loc - 1);
        quickSort(a, loc + 1, high);
    }

    public int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] input = {4, 13, 2, 8, 1, 5, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        for (int a : input) {
            System.out.print(a + " ");
        }
    }
}
