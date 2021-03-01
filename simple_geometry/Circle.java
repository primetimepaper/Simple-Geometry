public class Circle extends Shape{
    private double radius;
    

    public Circle(){
        super();
        this.radius = 1.0;
    }

    public Circle(Point p){
        super();
        this.radius = 1.0;
        super.setCentre(p);
    }

    public Circle(double r){
        super();
        this.radius = r;
    }

    public Circle(Point p, double r){
        super();
        this.radius = r;
        super.setCentre(p);
    }

    public Circle(double r, String c, boolean f){
        super(c, f);
        this.radius = r; 
    }

    public Circle(Point p, double r, String c, boolean f){
        super(c, f);
        this.radius = r;
        super.setCentre(p);
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
    
    public Point getCentre(){
        return super.getCentre();
    }

    public void setCentre(Point new_centre){
        super.setCentre(new_centre);
    }

    public String getColor(){
        return super.getColor();
    }

    public void setColor(String new_c){
        super.setColor(new_c);
    }

    public boolean isFilled(){
        return super.isFilled();
    }

    public void setFilled(boolean a){
        super.setFilled(a);
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Circle){
            Circle otherCircle = (Circle)other;
            if(this.radius == otherCircle.radius & this.getCentre().equals(otherCircle.getCentre())){
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
        super.MoveRight();
    }

    public void MoveLeft(){
        super.MoveLeft();
    }

    public void MoveUp(){
        super.MoveUp();
    }

    public void MoveDown(){
        super.MoveDown();
    }

    public void MoveTo(Point p){
        super.MoveTo(p);
    }
    
    public void Resize(double percent) {
        if(percent > 0){this.radius = this.radius * percent;}
    }
}
