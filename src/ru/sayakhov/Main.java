package ru.sayakhov;

import java.io.*;

import static ru.sayakhov.copyfiles.CopyFies.copyFiles;
import static ru.sayakhov.deletefiles.DeleteFiles.deleteDirectory;
import static ru.sayakhov.renamefiles.RenameFiles.rename;

public class Main {
    static int n = 0;
    static String[] pathArray = new String[0];
    static File newPath;

    public static void main(String[] args) throws IOException {

        //Создаем каталоги для создания вайлов и копирования
        File fileDir = new File("TEMP\\Inside\\Need\\Delete\\All");
        if (fileDir.mkdirs()) {
            System.out.println("Каталоги " + fileDir + " успешно создан");
        }
        File fileDestination = new File("Destination");
        if (fileDestination.mkdir()) {
            System.out.println("Каталог " + fileDestination + " успешно создан");
        }


        // Создаем фалы в каталоге:  "TEMP\inside\need\delete\all
        try {
            String filePath1 = "TEMP\\inside\\need\\delete\\All\\fileAll1.txt";
            File file1 = new File(filePath1);
            if (file1.createNewFile()) {
                System.out.println("Файл успешно создан");
            }
            String filePath2 = "TEMP\\inside\\need\\delete\\All\\fileAll2.txt";
            File file2 = new File(filePath2);
            if (file2.createNewFile()) {
                System.out.println("Файл успешно создан");
            }
            String filePath3 = "TEMP\\inside\\need\\delete\\All\\fileAll3.txt";
            File file3 = new File(filePath3);
            if (file3.createNewFile()) {
                System.out.println("Файл успешно создан");
            }
        } catch (IOException ex) {
            System.out.println("Ошибка при создании фалов");
        }

        //Копируем файлы в папку "Destination"
        copyFiles(fileDir, fileDestination);

        // Переименоваем файлы в папке "Destination"
        rename(fileDestination);

        // Написать рекурсивный обход всех файлов и подкаталогов внутри заданного каталога.
        // Программа должна следить за глубиной рекурсии, сдвигая название файла/каталога
        // на соответствующее количество пробелов.
        File x = fileDir.getParentFile();//Возвращает абстрактный путь родителя абстрактного пути, или null, если путь не указывает родительский каталог.
        String stringname = x.getName();// Возвращает имя файла или каталога, по указанному абстрактному имени пути.
        System.out.println(x + " " + stringname);
/*        pathArray = new String[5];
        pathArray[0] = fileDir.getName();
        pathArray[1] = fileDir.getName();

        */

        pathToArray(fileDir);
        for ( int i = pathArray.length; i >= 1; i-- ) {
            String line = " ";

            for (int n = 0; n < pathArray.length; n++) {
                StringBuilder sb = new StringBuilder(line.length() * n);
                sb.append(line);

            }
            System.out.print(line);
            System.out.println(pathArray[i-1]);


        }


        // Удаляем файлы, удаляем папки через рекурсией
        deleteDirectory(fileDir = new File("TEMP"));
    }


    private static void pathToArray(File path) {
        String[] pathArray2 = new String[pathArray.length + 1];
        for ( int i = 0; i < pathArray.length; i++ ) {
            pathArray2[i] = pathArray[i];
        }
        if (path != null) {
            pathArray2[pathArray.length] = path.getName(); //path.getParentFile().getName();
            pathArray = pathArray2;
            newPath = path.getParentFile();
            if (path.exists()) {
                pathToArray(newPath);
            }
        }
    }
}
