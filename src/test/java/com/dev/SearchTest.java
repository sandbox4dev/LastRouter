package com.dev;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vyacheslav on 22.11.2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchTest {
    private static final Logger log = LoggerFactory.getLogger(Service.class);
    private String filepath;

    @Before
    public void before() {
        this.filepath = "D:/tmp/test.txt";
    }

    @Test
    public void testDoMapOfRoutes() {
        File file = new File(filepath);

        Service service = new Service();
        assertTrue(service.searchRouteInMap(1, 0, service.doMapOfRoutes(file)));
        assertTrue(service.searchRouteInMap(0, 1, service.doMapOfRoutes(file)));
        assertTrue(service.searchRouteInMap(77, 5, service.doMapOfRoutes(file)));
        assertTrue(service.searchRouteInMap(5, 77, service.doMapOfRoutes(file)));
        assertFalse(service.searchRouteInMap(555, 0, service.doMapOfRoutes(file)));
        assertFalse(service.searchRouteInMap(0, 555, service.doMapOfRoutes(file)));
        assertFalse(service.searchRouteInMap(666, 69, service.doMapOfRoutes(file)));


    }
}
