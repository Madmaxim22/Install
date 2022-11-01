import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        final String PATH = "/home/maksim/Games/";
        List<File> dir = new ArrayList<>(Arrays.asList(
                new File(PATH, "src"), new File(PATH, "res"), new File(PATH, "savegames"), new File(PATH, "temp"),
                new File(PATH + "src", "main"), new File(PATH + "src", "test"),
                new File(PATH + "res", "drawables"), new File(PATH + "res", "vectors"), new File(PATH + "res", "icons"),
                new File(PATH + "src/main", "Main.java"), new File(PATH + "src/main", "Utils.java"),
                new File(PATH + "temp", "temp.txt")
        ));

        for (File file : dir) {
            stringBuilder.append(temp(file)).append(new Date()).append("  ");

        }
        try (FileWriter fileWriter = new FileWriter(PATH + "temp/temp.txt")) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String temp(File file) {
        boolean result = true;
        String name = file.getName();
        try {
            if (name.contains(".")) {
                result = file.createNewFile();
            } else {
                result = file.mkdirs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result ? name + "успешно создан\n" : name + "не создан\n";
    }
}
