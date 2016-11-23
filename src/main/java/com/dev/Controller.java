package com.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * Created by Vyacheslav on 22.11.2016.
 */

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Service.class);

    StopWatch watch = new StopWatch();

    @RequestMapping(value = "api/direct", method = RequestMethod.GET)
    public JsonResult getRes(@RequestParam("dep_sid") int dep_sid,
                             @RequestParam("arr_sid") int arr_sid) throws IOException {

        Service service = new Service();
        watch.start();
        boolean res = service.searchRouteInMap(dep_sid,arr_sid,service.doMapOfRoutes(Main.getFile()));
        watch.stop();
        log.info("Total time for reading,parsing,searching is {} sec",watch.getTotalTimeSeconds());
        return new JsonResult(dep_sid,arr_sid,res);

    }



}
