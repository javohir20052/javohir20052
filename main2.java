//*Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class main2 {

    static Logger logger;

    public static void main(String args[]) {
        String filePath = "src/main/java/org/example/log2_2.txt";
        createLogger();
        int[] bubbleArray = new int[]{548, 22, 1, 10, 7};
        System.out.println(Arrays.toString(bubbleArray));
        bubbleSort(bubbleArray);
        System.out.println(Arrays.toString(bubbleArray));
        closeLogger();
    }

    private static void closeLogger() {
        for (Handler handler : logger.getHandlers()) {
            handler.close();
        }
    }

    private static void createLogger() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("src/main/java/org/example/log2_2.txt", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFormatter formatter = new SimpleFormatter();
        if (fileHandler != null) {
            fileHandler.setFormatter(formatter);
        }
    }


    public static void bubbleSort(int[] bubbleArray) {
        for (int i = 0; i < bubbleArray.length; i++) {
            for (int j = 0; j < bubbleArray.length - 1; j++) {
                if (bubbleArray[j] > bubbleArray[j + 1]) {
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                }
                logger.info("Успешная итерация" + Arrays.toString(bubbleArray));
            }
        }
    }
}