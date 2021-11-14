package com.hicx.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class FileParser {


    public FileParser() {
    }

    public void parseFolder(String path) throws IOException {
        Stream<Path> paths = Files.walk(Paths.get(path)) ;
            paths
                    .filter(Files::isRegularFile)
                    .filter(file-> file.getFileName().toString().endsWith(Extensions.PLAIN_TEXT.getExt()))
                    .forEach(f-> parseFile(path,f.getFileName().toString())
                    );

    }

    public void parseFile(String path, String fileName)
    {
        Service service = new Service();
        try {
            File file = new File(path+fileName);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            System.out.println(":::::::::::::::::: FILENAME : "+ fileName + "  :::::::::::::::::::");
            String str = new String(data, "UTF-8");
            service.findStatictics(str);
            moveFileToProcessedFolder(path,fileName);
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void moveFileToProcessedFolder(String path,String fileName) throws IOException {
        Path source = Path.of(path+fileName);
        Path target = Path.of(path + "processed\\" +fileName);
        Files.createDirectories(target.getParent());
        Files.move(source, target,StandardCopyOption.REPLACE_EXISTING);
    }
}
