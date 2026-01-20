package tdd5;

import java.util.List;

public class FreshIdCalculator {

    public long calculateNumberOfFreshIds(List<Range> ranges, List<Long> ids) {
        long numberOfFreshIds = 0;
        for (Long id : ids) {
            for (Range range : ranges) {
                if (id >= range.min() && id <= range.max()) {
                    numberOfFreshIds++;
                    break;
                }
            }
        }
        return numberOfFreshIds;
    }
}
