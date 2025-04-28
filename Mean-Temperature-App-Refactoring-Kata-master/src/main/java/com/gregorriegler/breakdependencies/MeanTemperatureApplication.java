package com.gregorriegler.breakdependencies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;
import java.time.YearMonth;

/**
 * Prints the mean temperatures of 3 recent months measured in Vienna over the last 50 years for comparison.
 * <p>
 * Example Output:
 * 1969-09 to 1969-12 mean temperature: 7.7 °C
 * 1970-09 to 1970-12 mean temperature: 8.2 °C
 * 1971-09 to 1971-12 mean temperature: 7.9 °C
 * 1972-09 to 1972-12 mean temperature: 6.5 °C
 * 1973-09 to 1973-12 mean temperature: 7.4 °C
 * 1974-09 to 1974-12 mean temperature: 7.9 °C
 * ...
 * 2014-09 to 2014-12 mean temperature: 10.0 °C
 * 2015-09 to 2015-12 mean temperature: 9.7 °C
 * 2016-09 to 2016-12 mean temperature: 8.6 °C
 * 2017-09 to 2017-12 mean temperature: 9.1 °C
 * 2018-09 to 2018-12 mean temperature: 10.0 °C
 * 2019-09 to 2019-12 mean temperature: 10.1 °C
 */
public class MeanTemperatureApplication {
        private static final Logger LOG = LoggerFactory.getLogger(MeanTemperatureApplication.class);

    private final Outliner outliner;
    private final Statisttics statisttics;

    public MeanTemperatureApplication(Outliner outliner, Statisttics statisttics) {
        this.outliner = outliner;
        this.statisttics = statisttics;
    }

    public static void main(String[] args) {
        new MeanTemperatureApplication(new Outliner(), new Statisttics()).meanTemperature(Clock.systemDefaultZone());
    }

    public void meanTemperature(Clock clock) {
        YearMonth lastMonth = YearMonth.now(clock).minusMonths(2); // the climate api might not yet have data for the last month

        for (int year = lastMonth.getYear() - 50; year <= lastMonth.getYear(); year++) {
            double sum = 0;
            long count = 0;

            YearMonth end = lastMonth.withYear(year);
            YearMonth begin = end.minusMonths(3);

            double[] meanList = statisttics.bestMeanList(begin, end);

            for (int i = 0; i < meanList.length; i++) {
                double mean = meanList[i];
                sum += mean;
                count++;
            }

            if (count > 0) {
                double mean = sum / count;
                outliner.outline(end, begin, mean);
            }
        }

    }



}
