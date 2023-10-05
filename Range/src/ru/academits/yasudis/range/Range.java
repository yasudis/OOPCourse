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
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
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

    private boolean hasIntersection(Range range) {
        return this.from <= range.to && this.to >= range.from;
    }

    public Range getIntersection(Range range) {
        if (!(hasIntersection(range))) {
            return null;
        }

        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (!hasIntersection(range)) {
            Range[] result = new Range[2];

            result[0] = new Range(from, to);
            result[1] = new Range(range.from, range.to);

            return result;
        }

        double from = Math.min(this.from, range.from);
        double to = Math.max(this.to, range.to);

        Range[] result = new Range[1];

        result[0] = new Range(from, to);
        return result;
    }

    public Range[] getDifference(Range range) {
        if (!hasIntersection(range)) {
            Range[] result = new Range[1];
            result[0] = new Range(from, to);

            return result;
        }

        if (range.from > this.from && range.to <= this.to) {
            Range[] result = new Range[2];

            result[0] = new Range(this.from, range.from);
            result[1] = new Range(range.to, this.to);

            return result;
        } else if (range.from > this.from) {
            Range[] result = new Range[1];

            result[0] = new Range(this.from, range.from);

            return result;
        } else if (range.to <= this.to) {
            Range[] result = new Range[1];
            result[0] = new Range(range.to, this.to);
            return result;
        }

        return null;
    }

    @Override
    public String toString() {
        return "(" + getFrom() + ", " + getTo() + ")";
    }
}