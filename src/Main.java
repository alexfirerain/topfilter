import java.util.Arrays;

public class Saint {
    static int[][] regionals = {
            { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 },
            { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 },
            { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 }
    };
    public static void main(String[] args) {
        int[] national = selector(regionals, 10);
        System.out.println("Получилась такая команда:\n" +
                Arrays.toString(national));

    }

    public static int[] selector(int[][] teams, int count) {
        int[] result = new int[count];
        if (teams == null || teams.length == 0)
            return result;
        System.arraycopy(teams[0], 0, result, 0, result.length);

        for (int i = 1; i < teams.length; i++)
            result = mergeTop(result, teams[i], count);

        return result;
    }

    private static int[] mergeTop(int[] array_a, int[] array_b, int count) {
        int a = 0, b = 0;
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            int aTop = array_a[a];
            int bTop = array_b[b];
            if (aTop > bTop) {
                result[i] = aTop;
                a++;
            } else {
                result[i] = bTop;
                b++;
            }
        }

        return result;
    }

}