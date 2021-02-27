/*
 *   Copyright (c) 2021 Galimi
 *   All rights reserved.
 */
package pathfinder.src;

import java.util.ArrayList;
import java.util.Comparator;

public class Node extends Coord  {
  // public static Field field = new Field(1, 1, new Coord[] {});
  public int f, pathLength;
  public Node parent;

  public Node() {
    this.x = Coord.farPoint.x;
    this.y = Coord.farPoint.y;
    this.f = Coord.farPoint.x;
  }
  public Node(Coord point) {
    this.x = point.x;
    this.y = point.y;
  }
  public Node(Coord point, Coord goal, int h) {
    this.x = point.x;
    this.y = point.y;
    this.setF(goal, h);
  }

  // public void set(Node node) {
  //   this.x = node.x;
  //   this.y = node.y;
  //   this.f = node.f;
  //   this.pathLength = node.pathLength;
  //   setParent(node.parent);
  // }

  public void setF(Coord goal, int h) {
    // this.f = (int) (Math.sqrt(this.distance(goal)) + h); // TODO maybe find somehow to remove sqrt
    // this.f = (int) (this.distance(goal) + h);
    this.f = (int) (Math.abs(this.x-goal.x) + Math.abs(this.y-goal.y) + h);
    this.pathLength = h;
  }

  public Node setParent(Node parent) {
    this.parent = parent;
    return this;
  }

  public Node alreadyIn(ArrayList<Node> arr) {
    return arr
        .stream()
        .max((Comparator.comparing(x -> (x.equals(this)) ? 1 : 0)))
        .orElse(this);
    // for (Coordinate point: arr) {
    //     if (point.x() == this.x() && point.y() == this.y()) {
    //         return point;
    //         }
    //     }
    // return this;
}
}