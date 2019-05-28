class ArrayExceptionTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printArray(arr, 0, 10);

    }


    private static void printArray(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            try {
                System.out.println(arr[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка. Попытка обращения к\n" +
                        "несуществующему индексу: текущий индекс =" + i + "размер массива =" + arr.length);
            }

            System.out.println("Complete");


        }
    }
}



