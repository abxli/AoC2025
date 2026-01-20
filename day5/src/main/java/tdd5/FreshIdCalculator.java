package tdd5;

import java.util.ArrayList;
import java.util.Comparator;
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

    /**
     * Calculate all fresh ids given a list of ranges. Part 2 of day 5 AoC.
     *
     * @param ranges The ranges of fresh ids.
     * @return The number of all fresh ids.
     */
    public long calculateAllFreshIds(List<Range> ranges) {
        List<Range> sortedRanges = new ArrayList<>(ranges);
        sortedRanges.sort(Comparator.comparingLong(Range::min));

        List<Range> mergedRanges = keepMergingRangesUntilItCannotMergeAnymore(sortedRanges);

        return mergedRanges.stream()
                .mapToLong(r -> r.max() - r.min() + 1)
                .sum();
    }

    private static List<Range> keepMergingRangesUntilItCannotMergeAnymore(List<Range> sortedRanges) {
        List<Range> previousRanges = new ArrayList<>();
        List<Range> mergedRanges = sortedRanges;
        while (!mergedRanges.equals(previousRanges)) {
            previousRanges = mergedRanges;
            mergedRanges = mergeRanges(previousRanges);
        }
        return mergedRanges;
    }

    private static List<Range> mergeRanges(List<Range> sortedRanges) {
        List<Range> mergedRanges = new ArrayList<>();
        mergedRanges.add(sortedRanges.getFirst());

        for (int i = 1; i < sortedRanges.size(); i++) {
            Range currentRange = sortedRanges.get(i);
            boolean merged = false;

            for (int j = 0; j < mergedRanges.size(); j++) {
                Range otherRange = mergedRanges.get(j);
                if (currentRange.overlaps(otherRange)) {
                    merged = true;
                    mergedRanges.set(j, currentRange.takeUnionRangeWhenIntersecting(otherRange));
                    break;
                }
            }
            if (!merged) {
                mergedRanges.add(currentRange);
            }
        }
        return mergedRanges;
    }
}
