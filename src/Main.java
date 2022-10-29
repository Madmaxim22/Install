import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String path1 = "/home/maksim/Games";
        String path2 = "/home/maksim/Games/src";
        String path3 = "/home/maksim/Games/src/main";
        String path4 = "/home/maksim/Games/res";
        String path5 = "/home/maksim/Games/temp";

        String[] dirName1 = {"src", "res", "savegames", "temp"};
        String[] dirName2 = {"main", "test"};
        String[] dirName3 = {"drawables", "vectors", "icons"};
        String[] fileName1 = {"Main.java", "Utils.java"};
        String fileName2 = "temp.txt";

        StringBuilder sb = new StringBuilder();

        sb.append(createDir(path1, dirName1));
        sb.append(createDir(path2, dirName2));
        sb.append(createFile(path3, fileName1));
        sb.append(createDir(path4, dirName3));
        sb.append(createFile(path5, fileName2));

        try (FileOutputStream logs = new FileOutputStream(path5 + "/" + fileName2, true)) {
            byte[] bytes = sb.toString().getBytes();
            logs.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static StringBuilder createDir(String path, String... names) {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        for (String name : names) {
            File newDirectory = new File(path, name);
            if (!newDirectory.exists()) {
                if (newDirectory.mkdir()) {
                    sb.
                            append(date + "  ").
                            append(newDirectory.getName() + "   ").
                            append(" директрория успешно создана по пути ").
                            append(newDirectory.getAbsolutePath() + "\n");
                } else {
                    sb.
                            append(date + "  ").
                            append(newDirectory.getName() + "   ").
                            append(" директрория не создана по пути ").
                            append(newDirectory.getAbsolutePath() + "\n");
                }
            } else {
                sb.
                        append(date + "  ").
                        append(newDirectory.getName() + "   ").
                        append(" директрория уже существует по пути ").
                        append(newDirectory.getAbsolutePath() + "\n");
            }
        }
        return sb;
    }


    public static StringBuilder createFile(String path, String... names) {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        for (String name : names) {
            File newFile = new File(path, name);
            if (!newFile.exists()) {
                try {
                    if (newFile.createNewFile()) {
                        sb.
                                append(date + "  ").
                                append(newFile.getName() + "   ").
                                append(" файл успешно создан по пути ").
                                append(newFile.getAbsolutePath() + "\n");
                    }
                } catch (IOException e) {
                    sb.
                            append(date + "   ").
                            append(newFile.getName() + "  ").
                            append(" файл не создан по пути ").
                            append(newFile.getAbsolutePath() + "  ").
                            append(e.getMessage() + "\n");
                }
            } else {
                sb.
                        append(date + "   ").
                        append(newFile.getName() + "  ").
                        append(" файл уже существует по пути ").
                        append(newFile.getAbsolutePath() + "\n");
            }
        }
        return sb;
    }
}
