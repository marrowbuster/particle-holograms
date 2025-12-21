package com.marrowbuster.particleHolograms.shapes;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public record Vector(double x, double y, double z) {

    private static final double EPSILON = 1e-9;

    public static final Set<? extends CharSequence> VALID_KEYS = Set.of("x", "y", "z");


    public Vector(Vector other) {
        this(other.x(), other.y(), other.z());
    }

    public Vector(Number x, Number y, Number z) {
        this(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    public Vector add(double x, double y, double z) {
        return new Vector(this.x() + x,
                this.y() + y,
                this.z() + z);
    }

    public Vector add(List<? extends Number> coords) throws IllegalArgumentException {
        validateCoords(coords);
        return new Vector(this.x() + coords.get(0).doubleValue(),
                this.y() + coords.get(1).doubleValue(),
                this.z() + coords.get(2).doubleValue());
    }

    public Vector add(Map<String, ? extends Number> coords) throws IllegalArgumentException {
        validateKeys(coords.keySet());
        validateCoords(coords.values());

        return new Vector(this.x() + coords.get("x").doubleValue(),
                this.y() + coords.get("y").doubleValue(),
                this.z() + coords.get("z").doubleValue());
    }

    public Vector add(Number x, Number y, Number z) {
        return new Vector(this.x() + x.doubleValue(),
                this.y() + y.doubleValue(),
                this.z() + z.doubleValue());
    }

    public Vector add(Vector other) {
        return new Vector(this.x() + other.x(),
                this.y() + other.y(),
                this.z() + other.z());
    }

    public Vector cross(Vector other) {
        return new Vector(((this.y() * other.z()) - (this.z() * other.y())),
                (this.z() * other.x()) - (this.x() * other.z()),
                (this.x() * other.y()) - (this.y() * other.x()));
    }

    public double dot(Vector other) {
        return (this.x() * other.x()) + (this.y() * other.y()) + (this.z() * other.z());
    }

    public Vector invert() {
        return scale(-1);
    }

    public double magnitude() {
        return Math.sqrt((this.x() * this.x()) + (this.y() * this.y()) + (this.z() * this.z()));
    }

    public Vector normalise() throws IllegalArgumentException {
        double magnitude = this.magnitude();
        if (magnitude == 0) {
            throw new IllegalArgumentException("Can't normalise a zero vector!");
        }
        return new Vector(this.x() / magnitude,
                this.y() / magnitude,
                this.z() / magnitude);
    }

    public Vector normalize() throws IllegalArgumentException {
        try {
            return normalise();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Can't normalize a zero vector!");
        }
    }

    public static Vector of(List<? extends Number> coords) throws IllegalArgumentException {
        validateCoords(coords);
        return new Vector(coords.get(0).doubleValue(),
                coords.get(1).doubleValue(),
                coords.get(2).doubleValue());
    }

    public static Vector of(Map<? extends CharSequence, ? extends Number> coords) {
        validateKeys(coords.keySet());
        validateCoords(coords.values());

        return new Vector(coords.get("x").doubleValue(),
                coords.get("y").doubleValue(),
                coords.get("z").doubleValue());
    }

    public Vector scale(Number factor) {
        return new Vector(this.x() * factor.doubleValue(),
                this.y() * factor.doubleValue(),
                this.z() * factor.doubleValue());
    }

    public Vector subtract(double x, double y, double z) {
        return new Vector(this.x() - x,
                this.y() - y,
                this.z() - z);
    }

    public Vector subtract(List<? extends Number> coords) {
        validateCoords(coords);
        return new Vector(this.x() - coords.get(0).doubleValue(),
                this.y() - coords.get(1).doubleValue(),
                this.z() - coords.get(2).doubleValue());
    }

    public Vector subtract(Map<String, ? extends Number> coords) throws IllegalArgumentException {
        validateKeys(coords.keySet());
        validateCoords(coords.values());

        return new Vector(this.x() - coords.get("x").doubleValue(),
                this.y() - coords.get("y").doubleValue(),
                this.z() - coords.get("z").doubleValue());
    }

    public Vector subtract(Number x, Number y, Number z) {
        return new Vector(this.x() - x.doubleValue(),
                this.y() - y.doubleValue(),
                this.z() - z.doubleValue());
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x() - other.x(),
                this.y() - other.y(),
                this.z() - other.z());
    }

    public List<Double> toList() {
        return List.of(this.x(), this.y(), this.z());
    }

    public Map<String, Double> toMap() {
        Map<String, Double> coords = new HashMap<String, Double>();
        coords.put("x", this.x());
        coords.put("y", this.y());
        coords.put("z", this.z());

        return coords;
    }

    private static void validateCoords(Collection<? extends Number> coords) throws IllegalArgumentException {
        if (coords.size() != 3) {
            throw new IllegalArgumentException("Coordinate collection argument must have exactly three values. No more, no less.");
        }
    }

    private static void validateKeys(Set<? extends CharSequence> keys) {
        if (!keys.equals(VALID_KEYS)) {
            throw new IllegalArgumentException(("Map needs \"x\", \"y\", and \"z\" values. Those names."));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Vector other)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        return Math.abs(this.x() - other.x()) < EPSILON &&
                Math.abs(this.y() - other.y()) < EPSILON &&
                Math.abs(this.z() - other.z()) < EPSILON;
    }

    @Override
    public @NotNull String toString() {
        return "[" + this.x() + "," + this.y() + "," + this.z() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x(), this.y(), this.z());
    }
}
