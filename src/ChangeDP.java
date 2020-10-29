import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] moneyArray = new int[m + 1];
        int[] coins = new int[]{1, 3, 4};
        moneyArray[0] = 0;
        for (int i = 1; i < moneyArray.length; i++) {
            moneyArray[i] = 1000;
            int numOfCoins = 0;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    numOfCoins = moneyArray[i - coins[j]] + 1;
                    if (numOfCoins < moneyArray[i]) {
                        moneyArray[i] = numOfCoins;
                    }
                }
            }
        }
        return moneyArray[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

