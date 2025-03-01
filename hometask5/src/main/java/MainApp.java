import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        //1) Дан одноместный массив целых чисел. Необходимо получить второй,
        // который будут зеркальной копией первого (элементы наоборот - с последнего до первого)
        int[] firstArray = {1,6,8,2,9};
        int[] secondArray = new int[firstArray.length];
        for (int i=0; firstArray.length>i; i++) {
            secondArray[firstArray.length-i-1] = firstArray[i];
        }
        System.out.println(Arrays.toString(secondArray));
        //2) Дан массив целых чисел. Необходимо удалить элемент, расположенный по середине.
        int[] array = {1,7,2,6,5};
        int[] newArray = new int[array.length-1];
        int mid = array.length / 2;
        for (int i = 0, j = 0; firstArray.length>i; i++) {
            if (i == mid) {
                continue;
            }
            newArray[j]=array[i];
            j++;
        }
        System.out.println(Arrays.toString(newArray));
    }
}
