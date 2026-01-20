package tdd5;

import java.util.ArrayList;
import java.util.List;

public class InputTupleParser {
    public InputTuple parseTuples(List<String> lines) {
        int index = lines.indexOf("");

        List<Range> ranges = parseRanges(lines, index);
        List<Long> ids = lines.subList(index + 1, lines.size())
                .stream()
                .map(Long::parseLong)
                .toList();

        return new InputTuple(ranges, ids);
    }

    private List<Range> parseRanges(List<String> lines, int index) {
        List<Range> result = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            String[] chunks = lines.get(i).split("-");
            result.add(new Range(Long.parseLong(chunks[0]), Long.parseLong(chunks[1])));
        }
        return result;
    }
}
