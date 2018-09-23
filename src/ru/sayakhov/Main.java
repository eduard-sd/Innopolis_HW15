package ru.sayakhov;

import java.io.*;
import java.util.Arrays;

import static ru.sayakhov.copyfiles.CopyFies.copyFiles;
import static ru.sayakhov.deletefiles.DeleteFiles.deleteDirectory;
import static ru.sayakhov.renamefiles.RenameFiles.rename;

public class Main {
    static int n = 0;
    static String[] pathArray;
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
        System.out.println(x+" "+stringname);
/*        pathArray = new String[5];
        pathArray[0] = fileDir.getName();
        pathArray[1] = fileDir.getName();

        */
        metod(fileDir);



        // Удаляем файлы, удаляем папки через рекурсией
        deleteDirectory(fileDir=new File("TEMP"));
    }

    private static void metod(File path) {
        String[] pathArray = new String[1 + n];// задаем размер массива
        pathArray[n++] = path.getName();//присваем 0 идексу имя

        newPath = path.getParentFile();//переходим родительский каталлог

        if (newPath.exists()) {
                metod(newPath);//
        }
    }

    public static String[] getPathArray() {
        return pathArray;
    }

    public static void setPathArray(String[] pathArray) {
        Main.pathArray = pathArray;
    }
}
