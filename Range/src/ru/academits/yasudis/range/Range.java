package ru.academits.yasudis.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;

        sort();
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
        sort();
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
        sort();
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    private void sort() {
        if (to < from) {
            double temp = to;
            to = from;
            from = temp;
        }
    }

    private boolean isOutside(Range range) {
        return from > range.to || to < range.from;
    }

    public Range getIntersection(Range range) {
        if (isOutside(range)) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (from > range.to || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        double from = Math.min(this.from, range.from);
        double to = Math.max(this.to, range.to);

        return new Range[]{new Range(from, to)};
    }

    public Range[] getDifference(Range range) {
        if (isOutside(range)) {
            return new Range[]{new Range(from, to)};
        }

        if (range.from > from && range.to < to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (range.from > from) {
            return new Range[]{new Range(from, range.from)};
        }

        if (range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[0];
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }
}