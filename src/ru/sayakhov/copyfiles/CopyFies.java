package ru.sayakhov.copyfiles;

import java.io.*;

public class CopyFies {
    public static void copyFiles(File sourceLocation , File targetLocation) throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }
            File[] files = sourceLocation.listFiles();
            for(File file:files){
                InputStream in = new FileInputStream(file);
                OutputStream out = new FileOutputStream(targetLocation+"/"+file.getName());
                System.out.println("Файл успешно перемещен");

                // Copy the bits from input stream to output stream
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        }
    }
}
