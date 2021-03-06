/*
 *   Copyright (c) 2021 Galimi
 *   All rights reserved.
 */
package pathfinder.src;

import java.lang.Math;
import java.util.Arrays;
import java.util.stream.*;
import java.util.*;

public class Coord {
    public int x, y;
    public static Coord farPoint = new Coord(1000000,1000000); // extreme starting value
    public Coord() {
        this.x = farPoint.x;
        this.y = farPoint.y;
    }
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coord(int[] a) {
        this.x = a[0];
        this.y = a[1];
    }
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public boolean traversable(Field field) {
        return !(Arrays.asList(field.obstacles)
            .stream()
            .anyMatch(this::equals)) &&
            this.x <= field.maxX &&
            this.x >= field.minX &&
            this.y >= field.minY &&
            this.y <= field.maxY;
    }
    public double distance(Coord a) {
        return Math.pow(this.x-a.x, 2) + Math.pow(this.y-a.y, 2);
        // return Math.sqrt(Math.pow(this.x-a.x, 2) + Math.pow(this.y-a.y, 2));
    }
    public Coord closestTo(Coord[] coords) {
        return Arrays.asList(coords)
            .stream()
            .min(Comparator.comparing(this::distance))
            .orElseThrow(NoSuchElementException::new);
    }
    public Coord closestTo(Coord[] coords, int minDistance) {
        return Arrays.asList(coords)
            .stream()
            .filter(x -> x.distance(this) >= minDistance*minDistance)
            .min(Comparator.comparing(this::distance))
            .orElseThrow(NoSuchElementException::new);
    }
    public Coord[] findNeighbors() {
        return Coord.intArrToCoord(new int[][] {{this.x-1, this.y}, {this.x+1, this.y}, {this.x, this.y+1}, {this.x, this.y-1}});
    }
    public boolean exists() {
        return !(this.x == farPoint.x && this.y == farPoint.y); 
    }
    public boolean equals(Coord a) {
        return (this.x == a.x && this.y == a.y);
    }
    public boolean inside(ArrayList<Node> arr) {
        return arr
            .stream()
            .anyMatch(this::equals);
    }
    public static String toString(Coord a) {
        return (a.exists()) ? "("+a.x+", "+a.y+")" : "Doesn't exist";
    }
    public static String toString(Coord[] a) {
        String res = "(";
        for (int i = 0; i < a.length; i++) {
            res += Coord.toString(a[i]) + ((i == a.length-1) ? ")" : ", ");
        }
        return res;
    }
    public static Coord[] intArrToCoord(int[][] arr) {
        return Arrays.asList(arr)
            .stream()
            .map(x -> new Coord(x))
            .collect(Collectors.toList())
            .toArray(new Coord[0]);
    }
}
