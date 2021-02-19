package simple_geometry;

public abstract class Shape implements Movable, Resizable, GeometricObject{
    private String color;
    private boolean filled;
    private Point centre;

    public Shape(){
        this.color = "red";
        this.filled = true;
        Point centre = new Point(0,0);
        this.centre = centre;
    }

    public Shape(String c, boolean f){
        this.color = c;
        this.filled = f;
        Point centre = new Point(0,0);
        this.centre = centre;
    }

    public Point getCentre(){
        return this.centre;
    }

    public void setCentre(Point new_centre){
        this.centre = new_centre;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String new_c){
        this.color = new_c;
    }

    public boolean isFilled(){
        return this.filled;
    }

    public void setFilled(boolean a){
        this.filled = a;
    }

    public String toString(){
        String y = "A Shape with centre at " + this.centre + ", with color of " + this.color + " and filled.";
        String x = "A Shape with centre at " + this.centre + ", with color of " + this.color + " and not filled.";
        if (this.filled == true){
            return y;
        }
        else if (this.filled == false){
            return x;
        }
        else{
            return "???";
        }
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract boolean equals(Object other);
}
