package tdd5;

public record Range(long min, long max) {
    public boolean overlaps(Range otherRange) {
        return this.max >= otherRange.min && this.min <= otherRange.max;
    }

    public Range takeUnionRangeWhenIntersecting(Range otherRange) {
        if (!overlaps(otherRange)) return null;
        return new Range(Math.min(this.min, otherRange.min), Math.max(this.max, otherRange.max));
    }
}
