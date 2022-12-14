import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] national = select(regionals, 10);
        System.out.println("Получилась такая команда:\n" +
                Arrays.toString(national));
        System.out.println(Arrays.equals(national, expected) ?
                "Как и ожидал тренер." :
                "Но это не совсем то, что ожидалось.");
    }

    /**
     * Сортированные команды.
     */
    static int[][] regionals = {
            { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 },
            { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 },
            { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 }
    };

    /**
     * Ожидаемая сборная.
     */
    static int[] expected = { 51, 45, 31, 31, 30, 24, 22, 20, 18, 17 };

    /**
     * Собирает из предложенного массива нисходящих целочисленных массивов
     * новый нисходящий массив с заданным количеством элементов, максимальных из всех.
     * @param teams массив сортированных по убыванию массивов целых чисел,
     *             из которых требуется составить сборную.
     * @param count количество максимальных чисел, отбираемых в сборную.
     * @return  сортированный по убыванию массив, состоящий из самых больших значений
     * по всем исходным данным.
     */
    public static int[] select(int[][] teams, int count) {
        int[] result = new int[count];
        if (teams == null || teams.length == 0)
            return result;
        System.arraycopy(teams[0], 0, result, 0, result.length);

        for (int i = 1; i < teams.length; i++)
            result = mergeTop(result, teams[i], count);

        return result;
    }

    /**
     * Выбирает определённое количество максимальных значений
     * из двух сортированных по убыванию массивов.
     * Функция всегда возвращает сортированный по убыванию массив заданной длинны.
     * Если данных среди исходных массивов недостаточно для его заполнения,
     * недостающие данные восполняются нолями.
     * @param array_a один исходный сортированный по убыванию массив.
     * @param array_b другой исходный сортированный по убыванию массив.
     * @param count   длина результирующего массива.
     * @return  сортированный по убыванию массив заданной длины,
     * составленный из наибольших данных по обоим исходным массивам.
     */
    private static int[] mergeTop(int[] array_a, int[] array_b, int count) {
        int a = 0, b = 0;
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            if (a < array_a.length && b < array_b.length) {
                int aTop = array_a[a];
                int bTop = array_b[b];
                if (aTop >= bTop) {
                    result[i] = aTop;
                    a++;
                } else {
                    result[i] = bTop;
                    b++;
                }
            } else if (a < array_a.length) {
                result[i] = array_a[a];
                a++;
            } else if (b < array_b.length) {
                result[i] = array_b[b];
                b++;
            }
        }
        return result;
    }

}