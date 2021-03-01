package simple_geometry;
import java.util.Arrays;

public class Rectangle extends Shape {
    private double width;
    private double length;
    public Point[] edge;

    public Rectangle(){
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double w, double l){
        super();
        this.width = w;
        this.length = l;
    }

    public Rectangle(Point p, double w, double l){
        super();
        this.width = w;
        this.length = l;
        super.setCentre(p);
    }

    public Rectangle(double w, double l, String c, boolean f){
        super(c, f);
        this.width = w;
        this.length = l;
    }

    public Rectangle(Point p, double w, double l, String c, boolean f){
        super(c, f);
        this.width = w;
        this.length = l;
        super.setCentre(p);
    }

    public double getWidth(){
        return this.width;
    }

    public void setWidth(double new_w){
        this.width = new_w;
    }

    public double getLength(){
        return this.length;
    }

    public void setLength(double new_l){
        this.length = new_l;
    }

    public double getArea(){
        double Area = this.length * this.width;
        return Area;
    }

    public double getPerimeter(){
        double Perimeter = 2 * (this.length + this.width);
        return Perimeter;
    }

    public String getEdges(){
        // x plane is considered length, and y plane is considered width
        double Lx = super.getCentre().x - (this.length / 2);
        double Rx = super.getCentre().x + (this.length / 2);
        double Dy = super.getCentre().y - (this.width / 2);
        double Uy = super.getCentre().y + (this.width / 2);
        Point UL = new Point(Lx, Uy);
        Point UR = new Point(Rx, Uy);
        Point DL = new Point(Lx, Dy);
        Point DR = new Point(Rx, Dy);
        Point[] Edges = {DL, UL, UR, DR};
        this.edge = Edges;
        return Arrays.toString(Edges);
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Rectangle || other instanceof Square){
            Rectangle otherRectangle = (Rectangle) other;
            this.getEdges();
            otherRectangle.getEdges();
            System.out.println(otherRectangle);
            for(int i = 0; i < 4; i++){
                if(!(this.edge[i].equals(otherRectangle.edge[i]))){
                    return false;
                }
            }
            return true;
        }
        else{return false;}
    }

    @Override
    public void Resize(double percent){
        if(percent > 0){
            this.length *= percent;
            this.width *= percent;
        }
    }

    @Override
    public String toString(){
        String tostr = super.toString();
        String x = "A Rectangle with width " + this.width + " and length " + this.length + ", which is a subclass of " + tostr;
        return x;
    }

    public Point getCentre(){
        return super.getCentre();
    }

    public void setCentre(Point new_centre){
        super.setCentre(new_centre);
        this.getEdges();
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

    public void MoveDown(){
        super.MoveDown();
        this.getEdges();
    }

    public void MoveUp(){
        super.MoveUp();
        this.getEdges();
    }

    public void MoveLeft(){
        super.MoveLeft();
        this.getEdges();
    }

    public void MoveRight(){
        super.MoveRight();
        this.getEdges();
    }

    public void MoveTo(Point p){
        super.MoveTo(p);
        this.getEdges();
    }
}
