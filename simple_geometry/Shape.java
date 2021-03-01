public abstract class Shape implements Movable, Resizable, GeometricObject{
    private String colour;
    private boolean filled;
    private Point centre;

    public Shape(){
        this.colour = "red";
        this.filled = true;
        this.centre = new Point(0,0);
    }

    public Shape(String c, boolean f){
        this.colour = c;
        this.filled = f;
        this.centre = new Point(0,0);
    }

    public Point getCentre(){
        return this.centre;
    }

    public void setCentre(Point new_centre){
        this.centre = new_centre;
    }

    public String getColor(){
        return this.colour;
    }

    public void setColor(String new_c){
        this.colour = new_c;
    }

    public boolean isFilled(){
        return this.filled;
    }

    public void setFilled(boolean a){
        this.filled = a;
    }

    public String toString(){
        String y = "A Shape with (centre at " + this.centre + "), with color of " + this.colour + " and filled.";
        String x = "A Shape with (centre at " + this.centre + "), with color of " + this.colour + " and not filled.";
        if (this.filled == true){
            return y;
        }
        else{
            return x;
        }
    }

    public void MoveRight(){
        this.centre.x = this.centre.x + 1;
    }

    public void MoveLeft(){
        this.centre.x = this.centre.x - 1;
    }

    public void MoveUp(){
        this.centre.y = this.centre.y + 1;
    }

    public void MoveDown(){
        this.centre.y = this.centre.y - 1;
    }

    public void MoveTo(Point p){
        this.centre.x = p.x;
        this.centre.y = p.y;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract boolean equals(Object other);
}
