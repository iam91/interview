import java.util.HashMap;

public class GetNumberOfK {
    public int GetNumberOfK(int [] array, int k) {

        int first = getFirstK(array, k);
        int last = getLastK(array, k);
        if(first < 0)
            return 0;
        else
            return last - first + 1;
    }

    public int getLastK(int [] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = array[mid];
            if (midVal < k) {
                l = mid + 1;
            } else if (midVal > k) {
                r = mid - 1;
            } else if (mid + 1 < array.length && array[mid + 1] == k) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int getFirstK(int [] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = array[mid];
            if (midVal < k) {
                l = mid + 1;
            } else if (midVal > k) {
                r = mid - 1;
            } else if (mid - 1 >= 0 && array[mid - 1] == k) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

//    public int GetNumberOfK(int [] array , int k) {
//
//        int count = 0;
//
//        int l = 0, r = array.length - 1;
//        while(l <= r) {
//            int mid = (l + r) / 2;
//            int midVal = array[mid];
//            if(midVal == k) {
//                //count
//                count ++;
//                int i = mid + 1;
//                while(i < array.length && array[i] == k) {
//                    count++;
//                    i++;
//                }
//                i = mid - 1;
//                while(i >= 0 && array[i] == k) {
//                    count++;
//                    i--;
//                }
//                break;
//            } else if(midVal < k) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        GetNumberOfK c = new GetNumberOfK();

        int[] arr = {1, 2, 3, 3, 4, 50};
//        int[] arr = {3};

        System.out.println(c.GetNumberOfK(arr, 3));
    }
}