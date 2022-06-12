package sort;

/**
 * @author luna
 * 2022/6/12
 */
public class SwapFunction {


    /**
     * 三种交换方法
     * 对于冒泡、选择、插入等采用比较和交换元素的排序方法，由于经常执行交换操作，通常将交换动作写为swap方法，需要交换时调用。最常见swap写法是利用一个临时数tmp来交换arr[i]，arr[j]。也可以通过arr[i]和和arr[j]的加减运算避免临时数tmp的开销，但由于涉及到加减法可能导致数字「提前溢出」。第三种方法利用位运算中的异或运算，能够避免tmp的开销且不会导致数字溢出。需要特别注意的是，「方法二」和「方法三」
     * 要避免 i = j ，
     * 若 i = j，执行swap后将导致该数字变为0。实际上自我交换总是不必要的，
     * 因此应当保证swap被调用时 i !=j，这样就无需 if 语句了。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 方法一: 利用临时数tmp
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 方法二: 利用加减运算
     * @param arr
     * @param i
     * @param j
     */
    public static void swapCal(int[] arr, int i, int j) {
        if (i == j) {
            return; // 若无法保证swapCal被调用时满足 i != j，则需有此句，否则i == j时此数将变为0
        }
        arr[i] = arr[i] + arr[j]; // a = a + b
        arr[j] = arr[i] - arr[j]; // b = a - b
        arr[i] = arr[i] - arr[j]; // a = a - b
    }

    /**
     * 方法三: 利用异或运算
     * @param arr
     * @param i
     * @param j
     */
    public static void swapXOR(int[] arr, int i, int j) {
        if (i == j) {
            return; // 若无法保证swapXOR被调用时满足 i != j，则需有此句，否则i == j时此数将变为0
        }
        arr[i] = arr[i] ^ arr[j]; // a = a ^ b，也可写成 arr[i] ^= arr[j];
        arr[j] = arr[i] ^ arr[j]; // b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a， 也可写成 arr[j] ^= arr[i];
        arr[i] = arr[i] ^ arr[j]; // a = (a ^ b) ^ a = (a ^ a) ^ b = 0 ^ b = b， 也可写成 arr[i] ^= arr[j];
    }
}
