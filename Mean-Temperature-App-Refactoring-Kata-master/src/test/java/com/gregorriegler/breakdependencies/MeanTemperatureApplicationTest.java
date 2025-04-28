package com.gregorriegler.breakdependencies;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class MeanTemperatureApplicationTest {

    @Test
    void meanTemperature() {
        Outliner outliner = mock(Outliner.class);
        List<Tuple> monthTupleList = new ArrayList<>();
        Statisttics statisttics = mock(Statisttics.class);
        MeanTemperatureApplication meanTemperatureApplication = new MeanTemperatureApplication(outliner, statisttics){
            public double[] getMeanList(YearMonth begin, YearMonth end) throws IOException {
               monthTupleList.add(new Tuple(begin, end));
                return new double[]{1d,2d,3d};
            }
        };
        meanTemperatureApplication.meanTemperature(Clock.fixed(Instant.parse("2020-05-12T03:00:00Z"), ZoneOffset.UTC));

      assertThat(monthTupleList).hasSize(51)
              .startsWith(tuple(YearMonth.of(1969,12),YearMonth.of(1970, 3)))
              .endsWith(tuple(YearMonth.of(2019,12),YearMonth.of(2020, 3)));

      verify(outliner, times(51)).outline(any(), any(), eq(2d));

    }


    @Test
    void run_with_error() {
        Outliner outliner = mock(Outliner.class);
        List<Tuple> monthTupleList = new ArrayList<>();
        IOException exeptedDeclaration = new IOException("error");
        List<Exception> exceptionLis = new ArrayList<>();
        MeanTemperatureApplication meanTemperatureApplication = new MeanTemperatureApplication(outliner, new Statisttics()){


            public double[] getMeanList(YearMonth begin, YearMonth end) throws IOException {
                throw exeptedDeclaration;
            }

            public void logError(Exception e) {
                exceptionLis.add(exeptedDeclaration);
            }
        };
        meanTemperatureApplication.meanTemperature(Clock.fixed(Instant.parse("2020-05-12T03:00:00Z"), ZoneOffset.UTC));

        verifyNoInteractions(outliner);
        assertThat(exceptionLis).containsOnly(exeptedDeclaration);
    }
}