package ru.academits.yasudis.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;

        sortRange();
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

    public boolean isRange(double number) {
        return number >= from && number <= to;
    }

    private void sortRange() {
        if (to < from) {
            double temp = to;
            to = from;
            from = temp;
        }
    }

    private boolean isIntersection(Range rangeB) {
        return this.from <= rangeB.to && this.to >= rangeB.from;
    }

    public Double[] getIntersectionTwoIntervals(Range rangeB) {
        if (!(isIntersection(rangeB))) {
            return null;
        }

        Double[] result = new Double[2];

        result[0] = Math.max(this.from, rangeB.from);
        result[1] = Math.min(this.to, rangeB.to);

        return result;
    }

    public Range[] combiningIntervals(Range rangeB) {
        Range[] result = new Range[2];

        if (!isIntersection(rangeB)) {
            result[0] = new Range(this.from, this.to);
            result[1] = rangeB;

            return result;
        }

        double from = Math.min(this.from, rangeB.from);
        double to = Math.max(this.to, rangeB.to);

        result[0] = new Range(from, to);
        return result;
    }

    public Range[] subtractingIntervals(Range rangeB) {
        Range[] result = new Range[2];

        if (!isIntersection(rangeB)) {
            result[0] = new Range(from, to);
            return result;
        }

        if (rangeB.from > this.from) {
            result[0] = new Range(this.from, rangeB.from);

        } else {
            result[0] = null;

        }

        if (rangeB.to > this.to) {
            result[1] = null;
        } else {
            result[1] = new Range(rangeB.to, this.to);
        }

        return result;
    }

    public String showIntervals() {
        return (" от " + getFrom() + " до " + getTo());
    }
}