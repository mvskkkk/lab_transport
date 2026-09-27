package by.bsu.read;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class CarReader {
    private static final Logger LOG = LogManager.getLogger(CarReader.class);

    public static LinkedList<String> readLines(String path) {
        File file = new File(path);
        LinkedList<String> strings = new LinkedList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
            return strings;
        } catch (FileNotFoundException e) {
            LOG.error("File did not find: {}", path, e);
            throw new RuntimeException("File did not find");
        } finally {
            if (scanner != null) scanner.close();
        }
    }
}