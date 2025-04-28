package com.gregorriegler.breakdependencies;

import java.time.YearMonth;

public class Outliner {
     ThirdPartyService thirdPartyService = ThirdPartyService.getInstance();

    public Outliner() {
    }

   public void outline(YearMonth end, YearMonth begin, double mean) {
        thirdPartyService.outline(end, begin, mean);
    }
}