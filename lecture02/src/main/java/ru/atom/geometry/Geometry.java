package ru.atom.geometry;

/**
 *  ^ Y
 *  |
 *  |
 *  |
 *  |          X
 *  .---------->
 */

public final class Geometry {
    
    private Geometry() {
    }

    /**
     * Bar is a rectangle, which borders are parallel to coordinate axis
     * Like selection bar in desktop, this bar is defined by two opposite corners
     * Bar is not oriented
     * (It is not relevant, which opposite corners you choose to define bar)
     * @return new Bar
     */

    public static Collider createBar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
       Point point1 = new Point(firstCornerX, firstCornerY);
       Point point2 = new Point(secondCornerX, secondCornerY);
        Collider bar = new Bar(point1, point2);

        return bar;

    }

    /**
     * 2D point
     * @return new Point
     */
    public static Collider createPoint(int x, int y) {
        //throw new UnsupportedOperationException();
      Collider point = new Point(x, y);
      return point;
    }
}
