package com.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.*;
import java.util.*;

/**
 * Created by Vyacheslav on 22.11.2016.
 */
public class Service {

    private static final Logger log = LoggerFactory.getLogger(Service.class);

    /**
     * Read file lines into strings array, splitting elements of array into ArrayList<Integer>
     * and putting received arrays into Map. Key in map - first element of line,
     * set - List of remaining elements in line.
     *
     * @param file - path to file
     * @return - map - collection of routes
     * @throws IllegalArgumentException
     */
    public Map<Integer, List<Integer>> doMapOfRoutes(File file) throws IllegalArgumentException {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> stations;

        StopWatch watch = new StopWatch();
        watch.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String[] strRoutes;

            //Check cout of routes in routes map
            int quantityOfRoutes = Integer.parseInt(reader.readLine());
            if (quantityOfRoutes > 100000) {
                log.error("Upper limit for the number of bus routes is 100,000. Current count is" + quantityOfRoutes);
                throw new IllegalArgumentException("Limit exceeded routes. See log file");

            } else {
                for (int i = 0; i < quantityOfRoutes; i++) {
                    //Reading and splitting lines from file
                    strRoutes = reader.readLine().split(" ");

                    if (strRoutes.length - 1 < 3 || strRoutes.length > 1000) {
                        throw new IllegalArgumentException("Sorry, minimum len of route is - 3. Maximum route len is 1000");
                    }

                    Integer routeId = Integer.valueOf(strRoutes[0]);
                    stations = new ArrayList<>();
                    //fill list stations for map
                    for (int j = 1; j < strRoutes.length; j++) {
                        stations.add(Integer.valueOf(strRoutes[j]));
                    }
                    if (!map.containsKey(routeId)) {
                        map.put(routeId, stations);
                    }

                }
            }
        } catch (IOException e) {
            log.error("Input output exception, maybe file does not exist", e.getMessage());
        }
        finally {
            watch.stop();
            log.info("File {} read and parse, duration {} sec", file, watch.getTotalTimeSeconds());
        }
        System.out.println(map.size());
        return map;
    }

    /**
     * Search route in map by
     *
     * @param dep_sid - int departure station
     * @param arr_sid - int arrival station
     * @param map     - map of routes
     * @return true - direct route contain in value, false - not contain
     * @see HashMap
     * @see Set
     * @see Iterator
     */

    public boolean searchRouteInMap(int dep_sid, int arr_sid, Map<Integer, List<Integer>> map) {


        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();

        StopWatch watch = new StopWatch();
        watch.start();
        Map.Entry<Integer, List<Integer>> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getValue().contains(dep_sid) && entry.getValue().contains(arr_sid)) {
                return true;
            }
        }
        watch.stop();
        log.info("Searching in map, duration {} sec", watch.getTotalTimeSeconds());
        return false;

    }


}
