package ru.sayakhov;

import java.io.*;

import static ru.sayakhov.copyfiles.CopyFies.copyFiles;
import static ru.sayakhov.deletefiles.DeleteFiles.deleteDirectory;
import static ru.sayakhov.renamefiles.RenameFiles.rename;

public class Main {

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
        filePathOut(fileDir);

        // Удаляем файлы, удаляем папки через рекурсией
        deleteDirectory(fileDir=new File("TEMP"));
    }

    private static void filePathOut(File sourceLocation) {
        File[] files = sourceLocation.listFiles();
        for(files)
    }


}
