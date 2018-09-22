package ru.sayakhov.renamefiles;

import java.io.File;

public class RenameFiles {
    public static void rename(File sourceLocation) {
        File[] files = sourceLocation.listFiles();
        for ( File i : files){
            i.renameTo(new File("Destination/fileDest" + i + ".txt"));
            System.out.println("Файл переименован успешно");
        }
    }
}
