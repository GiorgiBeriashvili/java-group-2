package dev.beriashvili.practice;

class TestException {
    void exceptionOne() {
        int[] array = {1, 2, 3, 4, 5};

        try {
            System.out.println(array[15]);
        } catch (ArrayIndexOutOfBoundsException error) {
            error.printStackTrace();
        } finally {
            System.out.println("Exception handling is at its end.");
        }
    }

    void exceptionTwo() throws Exception {
        long millis = 2000;

        Thread.sleep(millis);

        System.out.println(String.format("Message after %d seconds!", millis / 1000));
    }
}
