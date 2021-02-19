package simple_geometry;
import java.util.Arrays;

public class Rectangle extends Shape {
    private double width;
    private double length;
    private Point[] edge;
    public Point centre;

    public Rectangle(){
        this.width = 1.0;
        this.length = 1.0;
        Point p = new Point();
        this.centre = p;
    }

    public Rectangle(double w, double l){
        this.width = w;
        this.length = l;
        Point p = new Point();
        this.centre = p;
    }

    public Rectangle(Point p, double w, double l){
        this.width = w;
        this.length = l;
        this.centre = p;
    }

    public Rectangle(double w, double l, String c, boolean f){
        this.width = w;
        this.length = l;
        super.setColor(c);
        super.setFilled(f);
        Point p = new Point();
        this.centre = p;
    }

    public Rectangle(Point p, double w, double l, String c, boolean f){
        this.width = w;
        this.length = l;
        super.setColor(c);
        super.setFilled(f);
        this.centre = p;
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
    public void MoveDown(){
        Point newcentre = super.getCentre();
        newcentre.MoveDown();
        this.centre = newcentre;
    }

    @Override
    public void MoveUp(){
        Point newcentre = super.getCentre();
        newcentre.MoveUp();
        this.centre = newcentre;
    }

    @Override
    public void MoveLeft(){
        Point newcentre = super.getCentre();
        newcentre.MoveLeft();
        this.centre = newcentre;
    }

    @Override
    public void MoveRight(){
        Point newcentre = super.getCentre();
        newcentre.MoveRight();
        this.centre = newcentre;
    }

    @Override
    public void MoveTo(Point p){
        super.setCentre(p);
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Rectangle){
            Rectangle otherrectangle = (Rectangle) other;
            this.getEdges();
            otherrectangle.getEdges();
            for(int i = 0; i < 4; i++){
                if(this.edge[i] != otherrectangle.edge[i]){
                    return false;
                }
            }
            return true;
        }
        else{return false;}
    }

    @Override
    public void resize(double percent){
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
}
