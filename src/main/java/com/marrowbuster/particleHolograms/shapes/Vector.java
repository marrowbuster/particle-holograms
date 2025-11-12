package com.marrowbuster.particleHolograms.shapes;

import lombok.*;

import java.util.*;

public class Vector {

    @Getter
    private final double x;
    @Getter
    private final double y;
    @Getter
    private final double z;

    public static final Set<? extends CharSequence> VALID_KEYS = Set.of("x", "y", "z");


    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    public Vector(Number x, Number y, Number z) {
        this(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    public Vector add(double x, double y, double z) {
        return new Vector(this.getX() + x,
                this.getY() + y,
                this.getZ() + z);
    }

    public Vector add(Number x, Number y, Number z) {
        return new Vector(this.getX() + x.doubleValue(),
                        this.getY() + y.doubleValue(),
                        this.getZ() + z.doubleValue());
    }

    public Vector add(Vector other) {
        return new Vector(this.getX() + other.getX(),
                            this.getY() + other.getY(),
                            this.getZ() + other.getZ());
    }

    public Vector add(List<? extends Number> coords) throws IllegalArgumentException {
        validateCoords(coords);
        return new Vector(this.getX() + coords.get(0).doubleValue(),
                        this.getY() + coords.get(1).doubleValue(),
                            this.getZ() + coords.get(2).doubleValue());
    }

    public Vector add(Map<String, ? extends Number> coords) throws IllegalArgumentException {
        validateKeys(coords.keySet());
        validateCoords(coords.values());

        return new Vector(this.getX() + coords.get("x").doubleValue(),
                this.getY() + coords.get("y").doubleValue(),
                this.getZ() + coords.get("z").doubleValue());
    }

    public Vector subtract(double x, double y, double z) {
        return new Vector(this.getX() - x,
                this.getY() - y,
                this.getZ() - z);
    }

    public Vector subtract(Number x, Number y, Number z) {
        return new Vector(this.getX() - x.doubleValue(),
                this.getY() - y.doubleValue(),
                this.getZ() - z.doubleValue());
    }

    public Vector subtract(Vector other) {
        return new Vector(this.getX() - other.getX(),
                        this.getY() - other.getY(),
                        this.getZ() - other.getZ());
    }

    public Vector subtract(List<? extends Number> coords) {
        validateCoords(coords);
        return new Vector(this.getX() - coords.get(0).doubleValue(),
                this.getY() - coords.get(1).doubleValue(),
                this.getZ() - coords.get(2).doubleValue());
    }

    public Vector subtract(Map<String, ? extends Number> coords) throws IllegalArgumentException {
        validateKeys(coords.keySet());
        validateCoords(coords.values());

        return new Vector(this.getX() - coords.get("x").doubleValue(),
                this.getY() - coords.get("y").doubleValue(),
                this.getZ() - coords.get("z").doubleValue());
    }

    public Vector scale(Number factor) {
        return new Vector(this.getX() * factor.doubleValue(),
                this.getY() * factor.doubleValue(),
                this.getZ() * factor.doubleValue());
    }

    public double dot(Vector other) {
        return (this.getX() * other.getX()) + (this.getY() * other.getY()) + (this.getZ() * other.getZ());
    }

    public Vector cross(Vector other) {
        return new Vector(((this.getY() * other.getZ()) - (this.getZ() * other.getY())),
                (this.getZ() * other.getX()) - (this.getX() * other.getZ()),
                (this.getX() * other.getY()) - (this.getY() * other.getX()));
    }


    public double magnitude() {
        return Math.sqrt((this.getX() * this.getX()) + (this.getY() * this.getY()) + (this.getZ() * this.getZ()));
    }

    public Vector normalise() throws IllegalArgumentException {
        double magnitude = this.magnitude();
        if (magnitude == 0) {
            throw new IllegalArgumentException("Can't normalise a zero vector!");
        }
        return new Vector(this.getX() / this.magnitude(),
                this.getY() / this.magnitude(),
                this.getZ() / this.magnitude());
    }

    public Vector normalize() throws IllegalArgumentException {
        try {
            return normalise();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Can't normalize a zero vector!");
        }
    }

    public Vector invert() {
        return new Vector(this.scale(-1));
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

    public Map<String, Double> toMap() {
        Map<String, Double> coords = new HashMap<String, Double>();
        coords.put("x", this.getX());
        coords.put("y", this.getY());
        coords.put("z", this.getZ());

        return coords;
    }

    public List<Double> toList() {
        return List.of(this.getX(), this.getY(), this.getZ());
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

        return (this.getX() == other.getX()) &&
                (this.getY() == other.getY()) &&
                (this.getZ() == other.getZ());
    }

    @Override
    public String toString() {
        return "[" + this.getX() + "," + this.getY() + "," + this.getZ() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getZ());
    }
}
