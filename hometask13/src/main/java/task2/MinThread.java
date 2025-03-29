package task2;

public class MinThread implements Runnable{
    private int[] numbers;
    private int minNum;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
        this.minNum = Integer.MAX_VALUE;
    }

    @Override
    public void run() {
        for (int num : numbers) {
            if (num < minNum) {
                minNum = num;
            }
        }
    }
    public int getMinNum() {
        return minNum;
    }
}
