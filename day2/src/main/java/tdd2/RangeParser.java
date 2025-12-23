package tdd2;

import java.util.ArrayList;
import java.util.List;

public class RangeParser {
    public Range parseRange(String rangeInput) {
        String[] ranges = rangeInput.split("-");
        long firstId = Long.parseLong(ranges[0]);
        long lastId = Long.parseLong(ranges[1]);
        return new Range(firstId, lastId);
    }

    public List<Range> parseRanges(List<String> ranges) {
        List<Range> result = new ArrayList<>();
        ranges.forEach(range -> result.add(parseRange(range)));

        return result;
    }
}
