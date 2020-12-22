import Coord;
import Node;

public class Field {
  public Coord[] obstacles;
  public int length, width;
  public int minX = 0, minY = 0, maxX, maxY;
  // public Node[][] points;

  public Field(int length, int height, Coord[] obstacles) {
    this.obstacles = obstacles;
    this.length = length;
    this.height = height;
    // this.points = new Node[height][length];
    // setPoints();
    this.maxY = height;
    this.maxX = length;
  }

  // private void setPoints() {
  //   for (int row = 0; row < height; i++) {
  //     for (int col = 0; col < length; i++) {
  //       points[row][col] = new Node(col, row);
  //     }
  //   }
  // }

  // sets minimums and maxium field values
  public void setExtremes(int minX, int minY, int maxX, int maxY) {
    this.minX = minX;
    this.minY = minY;
    this.maxX = maxX;
    this.maxY = maxY;
  }
}