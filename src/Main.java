import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String GAMES = "D:/Games";
    public static void main(String[] args) throws IOException {
        directories();        // хранение
        сreateFiles();        // создание файлов
        record();             // запись
    }
    public static List<File> directories() {
        List<String> arr = new ArrayList<>();
        arr.add(GAMES + "/src");
        arr.add(GAMES + "/src/main");
        arr.add(GAMES + "/src/test");
        arr.add(GAMES + "/res");
        arr.add(GAMES + "/res/drawables");
        arr.add(GAMES + "/res/vectors");
        arr.add(GAMES + "/res/icons");
        arr.add(GAMES + "/savegames");
        arr.add(GAMES + "/temp");

        List<File> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            result.add(new File(arr.get(i)));
        }

        for (File resultAll : result) {
            resultAll.mkdir();
            resultAll.exists();
        }
        return result;
    }

    public static List<File> сreateFiles() throws IOException {

        String main = GAMES + "/src/main";
        String temp = GAMES + "/temp";

        List<String> fileNames = new ArrayList<>();
        fileNames.add(main + "/Main.java");
        fileNames.add(main + "/Utils.java");
        fileNames.add(temp + "/temp.txt");

        List<File> fileList = directories();
        for (int i = 0; i < fileNames.size(); i++)
            fileList.add(new File(fileNames.get(i)));
        for (File resultMainAll : fileList) {
            resultMainAll.createNewFile();
            System.out.println(resultMainAll.exists());         }
        return fileList;
    }

    public static void record() throws IOException {

        String tempTxt = GAMES + "\\temp\\temp.txt";
        File file = new File(tempTxt);
        String text = file.getCanonicalPath() + " существует файл - " + file.exists();
        if (!file.exists()) {
            System.out.println(file.getCanonicalPath() + " не существует файл.");
            return;
        }

        try (FileWriter writer = new FileWriter(tempTxt, true)) {
            writer.write(text);
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());                                            
        }
    }
}