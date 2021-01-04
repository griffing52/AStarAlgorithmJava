package pathfinder.src;

import java.util.ArrayList;

public class Node extends Coord {
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

  public void setF(Coord goal, int h) {
    this.f = (int) this.distance(goal) + h;
    this.pathLength = h;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }
}