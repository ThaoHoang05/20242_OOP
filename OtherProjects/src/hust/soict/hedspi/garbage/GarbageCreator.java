package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "D:\\JavaProgramming\\20242_OOP\\OtherProjects\\hust\\soict\\hedspi\\garbage\\garbage";
        byte[] input = { 0 };
        long startTime, endTime;

        try {
            input = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        StringBuilder output = new StringBuilder();
        for (byte b : input) {
            output.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
