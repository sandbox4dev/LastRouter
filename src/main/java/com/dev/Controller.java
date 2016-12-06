package com.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Vyacheslav on 22.11.2016.
 */

@RestController
public class Controller {

    @RequestMapping(value = "api/direct", method = RequestMethod.GET)
    public JsonResult getRes(@RequestParam("dep_sid") int dep_sid,
                             @RequestParam("arr_sid") int arr_sid) throws IOException {

        Service service = new Service();

        boolean res = service.searchRouteInMap(dep_sid,arr_sid,Main.getMap());
        return new JsonResult(dep_sid,arr_sid,res);

    }



}
