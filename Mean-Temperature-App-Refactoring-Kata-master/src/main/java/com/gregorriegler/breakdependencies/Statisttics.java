package com.gregorriegler.breakdependencies;

import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.time.YearMonth;

public class Statisttics {

    private static final Logger LOG = LoggerFactory.getLogger(Statisttics.class);

    public Statisttics() {
    }

    double[] bestMeanList(YearMonth begin, YearMonth end) {
        double[] meanList = null;
        try {
            URL url = new URL("https://api.meteostat.net/v1/history/monthly?station=11035&start=" + begin + "&end=+" + end + "&key=" + System.getProperty("key"));
            double[] meanList1 = JsonPath.parse(url).read("$.data[*].temperature_mean", double[].class);
            meanList = meanList1;
        } catch (Exception e) {
            LOG.error("an error occured", e);
        }
        return meanList;
    }
}