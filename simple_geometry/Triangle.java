package simple_geometry;

import java.util.Arrays;
import java.util.ArrayList;

public class Triangle extends Shape{
    private boolean sideFlag = false; //To check if sides have been declared, else defaults to equilateral triangle
    private Line[] sides;
    
    public Triangle(){
        super();
        Point A = new Point(super.getCentre().x, super.getCentre().y + (Math.sqrt(3) / 4));
        Point B = new Point(super.getCentre().x - 0.5, super.getCentre().y - (Math.sqrt(3) / 4));
        Point C = new Point(super.getCentre().x + 0.5, super.getCentre().y - (Math.sqrt(3) / 4));
        this.sides = new Line[] {new Line(A, B), new Line(B, C), new Line(C, A)};
        this.sideFlag = true;
        //intialiases an equilateral triangle with side of length 1
    }

    public Triangle(Point p){
        super();
        super.setCentre(p);
        this.setEdgesByCentre();
    }

    public Triangle(String c, boolean f){
        super(c, f);
        Point A = new Point(super.getCentre().x, super.getCentre().y + (Math.sqrt(3) / 4));
        Point B = new Point(super.getCentre().x - 0.5, super.getCentre().y - (Math.sqrt(3) / 4));
        Point C = new Point(super.getCentre().x + 0.5, super.getCentre().y - (Math.sqrt(3) / 4));
        this.sides = new Line[] {new Line(A, B), new Line(B, C), new Line(C, A)};
        this.sideFlag = true;
        //intialiases an equilateral triangle with side of length 1
    }

    public Triangle(Point p, String c, boolean f){
        super(c, f);
        super.setCentre(p);
        this.setEdgesByCentre();
    }

    public Triangle(Point p, Point A, Point B, Point C){
        super();
        super.setCentre(p);
        this.sides = new Line[] {new Line(A, B), new Line(B, C), new Line(C, A)};
        this.sideFlag = true;
    }

    public Triangle(Point p, Line A, Line B, Line C){
        super();
        super.setCentre(p);
        this.sides = new Line[] {A, B, C};
        this.sideFlag = true;
    }

    public String getEdges(){
        ArrayList<Point> edge = new ArrayList<Point>();
        for(int i = 0; i < 3; i++){
            if(!edge.contains(sides[i].getStart())){edge.add(sides[i].getStart());}
            if(!edge.contains(sides[i].getEnd())){edge.add(sides[i].getEnd());}
        }
        return edge.toString();
    }

    public void setEdge(String target, Point a){
        if(target == "A" || target == "1"){this.sides[0].setStart(a);this.sides[2].setEnd(a);}
        else if(target == "B" || target == "2"){this.sides[1].setStart(a);this.sides[0].setEnd(a);}
        else if(target == "C" || target == "3"){this.sides[2].setStart(a);this.sides[1].setEnd(a);}
    }

    public void setEdgesByCentre(){
        if(this.sideFlag){//TODO

        }
        else{ // defaults to drawing an equilateral triangle with sides of length 1
            Point A = new Point(super.getCentre().x, super.getCentre().y + (Math.sqrt(3) / 4));
            Point B = new Point(super.getCentre().x - 0.5, super.getCentre().y - (Math.sqrt(3) / 4));
            Point C = new Point(super.getCentre().x + 0.5, super.getCentre().y - (Math.sqrt(3) / 4));
            this.sides = new Line[] {new Line(A, B), new Line(B, C), new Line(C, A)};
            this.sideFlag = true;
        }
    }

    public void Resize(double percent){
        //TODO resizing relative to centre, using angles and edge coordinates.
    }

    public double[] getAngles(){ //Cosine Rule
        double[] angles = {-1.0, -1.0, -1.0};
        angles[0] = Math.acos((Math.pow(this.sides[1].getLength(),2) + Math.pow(this.sides[2].getLength(),2) - Math.pow(this.sides[0].getLength(),2)) / (2 * this.sides[1].getLength() * this.sides[2].getLength())) * (180/Math.PI);
        angles[1] = Math.acos((Math.pow(this.sides[0].getLength(),2) + Math.pow(this.sides[2].getLength(),2) - Math.pow(this.sides[1].getLength(),2)) / (2 * this.sides[0].getLength() * this.sides[2].getLength())) * (180/Math.PI);
        angles[2] = Math.acos((Math.pow(this.sides[0].getLength(),2) + Math.pow(this.sides[1].getLength(),2) - Math.pow(this.sides[2].getLength(),2)) / (2 * this.sides[0].getLength() * this.sides[1].getLength())) * (180/Math.PI);
        return angles;
    }

    public double getArea(){ // Uses Heron's Formula
        double s = this.getPerimeter() / 2;
        return Math.sqrt(s * (s - this.sides[0].getLength()) * (s - this.sides[1].getLength()) * (s - this.sides[2].getLength()));
    }

    public double getPerimeter(){
        return (this.sides[0].getLength() + this.sides[1].getLength() + this.sides[2].getLength());
    }

    @Override
    public String toString(){
        String tostr = super.toString();
        double[] lengths = {this.sides[0].getLength(), this.sides[1].getLength(), this.sides[2].getLength()};
        String x = "A Triangle with sides of lengths " + Arrays.toString(lengths) + ", which is a subclass of " + tostr;
        return x;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Triangle){
            int flag = 0;
            Triangle otherTriangle = (Triangle) other;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(this.sides[i].equals(otherTriangle.sides[j])){flag = 1;}
                }
                if(flag == 0){return false;} else{flag = 0;}
            }
            return true;
        }
        else{return false;}
    }

    public Point getCentre(){return super.getCentre();}
    public void setCentre(Point new_centre){super.setCentre(new_centre); this.setEdgesByCentre();}
    public String getColor(){return super.getColor();}
    public void setColor(String new_c){super.setColor(new_c);}
    public boolean isFilled(){return super.isFilled();}
    public void setFilled(boolean a){super.setFilled(a);}

    public void MoveDown(){super.MoveDown(); this.setEdgesByCentre();}
    public void MoveUp(){super.MoveUp(); this.setEdgesByCentre();}
    public void MoveLeft(){super.MoveLeft(); this.setEdgesByCentre();}
    public void MoveRight(){super.MoveRight(); this.setEdgesByCentre();}
    public void MoveTo(Point p){super.MoveTo(p); this.setEdgesByCentre();}
}
