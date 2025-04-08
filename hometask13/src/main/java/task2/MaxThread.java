package task2;

public class MaxThread implements Runnable{

    private int[] numbers;
    private int maxNum;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
        this.maxNum = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        for (int num : numbers) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
    }
    public int getMaxNum() {
        return maxNum;
    }
}
