package ru.atom.geometry;

public class Bar implements  Collider{
    private Point point1;
    private Point point2;

    private boolean CheckPoint(Point p, Bar b)
    {
        if(p.getX() >= b.point1.getX() &&
                p.getY() >= b.point1.getY() &&
                p.getX()<= b.point2.getX() &&
                p.getY()<= b.point2.getY())
            return true;
        else return  false;
    }

    public Bar(Point point1, Point point2){
        this.point1=point1;
        this.point2=point2;
        if(this.point1.getX() > this.point2.getX())
        {
            int tmp = this.point1.getX();
            this.point1.setX(this.point2.getX());
            this.point2.setX(tmp);
        }
        if(this.point1.getY() > this.point2.getY())
        {
            int tmp = this.point1.getY();
            this.point1.setY(this.point2.getY());
            this.point2.setY(tmp);
        }
    }

    @Override
    public boolean isColliding(Collider other) {
        return this.equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Bar)
        {
            Bar otherBar = (Bar) o;

            if (CheckPoint(otherBar.point1,this) ||
                    CheckPoint(otherBar.point2,this) ||
                    CheckPoint(new Point(otherBar.point2.getX(),otherBar.point1.getY()),this) ||
                    CheckPoint(new Point(otherBar.point1.getX(),otherBar.point2.getY()),this))
                return true;
            else if(otherBar.point2.getX() <=this.point2.getX() && otherBar.point1.getX() >= this.point1.getX()
                    && otherBar.point2.getY() >= this.point2.getY() && otherBar.point1.getY() <= this.point1.getY() ||
                    otherBar.point2.getY() <=this.point2.getY() && otherBar.point1.getY() >= this.point1.getY()
                            && otherBar.point2.getX() >= this.point2.getX() && otherBar.point1.getX() <= this.point1.getX())
                return true;
        }
        else if (o instanceof  Point)
        {
            Point otherPoint = (Point) o;
            if(CheckPoint(otherPoint,this))
                return true;
        }
        return false;
    }

}
