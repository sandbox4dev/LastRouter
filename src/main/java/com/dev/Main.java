package com.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vyacheslav on 22.11.2016.
 */

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Service.class);

    private static File file;
    static Map<Integer, List<Integer>> map;

    public static File getFile() {
        return file;
    }

    public static Map<Integer, List<Integer>> getMap() {
        return map;
    }

    public static void main(String[] args) throws FileNotFoundException {

        SpringApplication.run(Main.class, args);
        try {
            file = new File("D:/tmp/test.txt");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("File not found, please enter absolute file path, for example: " +
                    "- D:/tmp/test. Current path is {}", args[0]);
        }
        Service service = new Service();
        map = new HashMap<>(service.doMapOfRoutes(file));


    }
}
