package com.hicx.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@SpringBootApplication
public class HicxTestApplication implements ApplicationRunner {


    @Value("${path}")
    private String path;

    public static void main(String[] args) {
        SpringApplication.run(HicxTestApplication.class, args);
    }

    @Override
    public void run( ApplicationArguments args ) throws Exception
    {
        FileParser fileParser = new FileParser();
        fileParser.parseFolder(path);
    }

}
