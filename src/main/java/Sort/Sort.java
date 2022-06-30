package Sort;

public class Sort {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    交换排序，稳定，适用于整体有序的情况
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /*
    属于选择排序，不稳定，如果是向下建堆O(N),如果是向下插入建堆O(nlogn),向上插入建堆是O(n),每一次选择一个当前规模下的最大节点并调整，
    因为一共是N个节点且调整的时间复杂度为O(logn),所以整体时间复杂度为(nlogn)
     */
    public void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length); //建堆，这一步的关键意义在于使数组局部有序
        }
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j); //注意，找出最大的后，堆的长度就减少1
            heapify(nums, 0, j);//因此对长度-1后的堆进行调整，只调整被交换节点的子堆
        }
    }
    //此处用的是向下调整，适用于只删除场景，向上调整适用于插入场景
    public void heapify(int[] nums, int i, int size) {
        for (int k = 2 * i + 1; k < size; k = 2 * k + 1) {
            if (nums[k] > nums[k + 1] && k < size) {
                k++;
            }
            //如果发生交换，需要对被交换子节点为根节点的子堆进行调整
            if (nums[k] > nums[i]) {
                swap(nums, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    /*
    多线程 不稳定 O(nlogn)~O(n2)
    给插入排序多一个gap即可
     */
    public void hillSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i - gap;
                for (; j >= 0 && temp < nums[j]; j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = temp;
            }
        }
    }

    /*
    稳定
    在基本有序的数组中时间复杂度接近O(N)
    可以再插入过程中使用折半查找法提高效率
     */
    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0 && temp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    /*
    稳定排序，但效率上相比快速排序常数项较大
    多线程
     */
    public void mergeSort(int[] nums, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, h);

            int[] temp = new int[h - l + 1];
            int p1 = l;
            int p2 = mid + 1;
            int k = 0;
            while (p1 <= mid && p2 <= h) {
                if (nums[p1] > nums[p2]) {
                    temp[k++] = nums[p2++];
                } else {
                    temp[k++] = nums[p1++];
                }
            }
            while (p1 <= mid) temp[k++] = nums[p1++];
            while (p2 <= h) temp[k++] = nums[p2++];
            for (int i = 0; i < temp.length; i++) {
                nums[l + i] = temp[i];
            }
        }
    }

    /*
    pivot选的不好容易退化成冒泡排序，选pivot的方法可以是随机选，三值取中法等
    交换排序，不稳定，是目前最快的排序算法
     */
    public void quickSort(int[] nums, int l, int h) {
        if (l < h) {
            int low = l;
            int high = h;
            int pivot = nums[l];
            while (low < high) {
                while (nums[high] >= pivot && low < high) high--;
                nums[low] = nums[high];
                while (nums[low] <= pivot && low < high) low++;
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            quickSort(nums, l, low - 1);
            quickSort(nums, low + 1, h);
        }
    }

    /*
    各种情况下效率变化不大，是比较稳定的排序
     */
    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = 50001;
            int minIndex = -1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIndex] = temp;
        }
    }
}
