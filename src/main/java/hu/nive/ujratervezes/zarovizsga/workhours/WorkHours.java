package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file) {
        int min = Integer.MAX_VALUE;
        String result = "";
        Path source = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(source)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[1]) <= min) {
                    min = Integer.parseInt(parts[1]);
                    result = parts[0].concat(": ").concat(parts[2]);
                }
            }
            return result;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }


}
