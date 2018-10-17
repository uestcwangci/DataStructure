package javastructure.unit9;

public class DebugSearch {
    public static void main(String[] args) {
        DebugSearch debug = new DebugSearch();
        int[] order = {12, 23, 26, 37, 54, 60, 68, 75, 82, 96};
        System.out.println(debug.binarySearch(order, 11));

    }

    public int binarySearch(int[] order, int key) {
        int left = 0;
        int right = order.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (key > order[mid]) {
                left = mid + 1;
            } else if (key < order[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
