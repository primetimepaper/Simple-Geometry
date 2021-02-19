public class Circle extends Shape{
    private double radius;
    private Point centre;
    

    public Circle(){
        Point p = new Point();
        this.centre = p;
        this.radius = 1.0;
    }

    public Circle(Point p){
        this.radius = 1.0;
        this.centre = p;
    }

    public Circle(double r){
        this.radius = r;
        Point p = new Point();
        this.centre = p;
    }

    public Circle(Point p, double r){
        this.radius = r;
        this.centre = p;
    }

    public Circle(double r, String c, boolean f){
        this.radius = r; 
        super.setColor(c);
        super.setFilled(f);
        Point p = new Point();
        this.centre = p;
    }

    public Circle(Point p, double r, String c, boolean f){
        this.radius = r; 
        super.setColor(c);
        super.setFilled(f);
        this.centre = p;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double new_r){
        this.radius = new_r;
    }

    public double getArea(){
        double Area = Math.PI * Math.pow(this.radius, 2);
        return Area;
    }

    public double getPerimeter(){
        double Perimeter = 2 * Math.PI * this.radius;
        return Perimeter;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Circle){
            Circle othercircle = (Circle)other;
            if(this.radius == othercircle.radius & this.centre == othercircle.centre){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }

    @Override
    public String toString(){
        String tostr = super.toString();
        String x = "A Circle with radius " + this.radius + ", which is a subclass of " + tostr;
        return x;
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

    public void resize(double percent) {
        if(percent > 0){this.radius = this.radius * percent;}
    }

}