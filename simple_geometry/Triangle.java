import java.util.Arrays;

public class Triangle extends Shape{
    //private Point A; private Point B; private Point C;
    private Point[] edges;
    
    public Triangle(){
        super();
        //intialiases an equilateral triangle with side of length 1
        edges = new Point[] {new Point(0.0, Math.sqrt(3) / 4), new Point(-0.5, -Math.sqrt(3) / 4), new Point(0.5, -Math.sqrt(3) / 4)};
    }

    public Triangle(Point p){
        super();
        super.setCentre(p);
    }

    public Triangle(String c, boolean f){
        super(c, f);
    }

    public Triangle(Point p, String c, boolean f){
        super(c, f);
        super.setCentre(p);
    }

    public String getEdges(){
        return Arrays.toString(this.edges);
    }

    public void setEdge(String target, Point a) throws Error{
        if(target == "A" || target == "1"){this.edges[0] = a;}
        else if(target == "B" || target == "2"){this.edges[1] = a;}
        else if(target == "C" || target == "3"){this.edges[2] = a;}
    }

    public void setEdgesByCentre(Point Centre){
        //TODO Resize() first?
    }

    public void Resize(double percent){
        //TODO resizing relative to centre, using angles and edge coordinates.
    }

    public double[] getAngles(){ //Cosine Rule
        double[] angles = {-1.0, -1.0, -1.0};
        double A = this.edges[0].EucledianDistance(this.edges[1]); double B = this.edges[1].EucledianDistance(this.edges[2]); double C = this.edges[2].EucledianDistance(this.edges[0]);
        angles[0] = Math.acos((Math.pow(B,2) + Math.pow(C,2) - Math.pow(A,2)) / (2 * B * C)) * (180/Math.PI);
        angles[1] = Math.acos((Math.pow(A,2) + Math.pow(C,2) - Math.pow(B,2)) / (2 * A * C)) * (180/Math.PI);
        angles[2] = Math.acos((Math.pow(A,2) + Math.pow(B,2) - Math.pow(C,2)) / (2 * A * B)) * (180/Math.PI);
        return angles;
    }

    public double getArea(){ // Uses Heron's Formula
        double s = this.getPerimeter() / 2;
        return Math.sqrt(s * (s - this.edges[0].EucledianDistance(this.edges[1])) * (s - this.edges[1].EucledianDistance(this.edges[2])) * (s - this.edges[2].EucledianDistance(this.edges[0])));
    }

    public double getPerimeter(){
        return (this.edges[0].EucledianDistance(this.edges[1]) + this.edges[1].EucledianDistance(this.edges[2]) + this.edges[2].EucledianDistance(this.edges[0]));
    }

    @Override
    public String toString(){
        String tostr = super.toString();
        double[] lengths = {this.edges[0].EucledianDistance(this.edges[1]), this.edges[1].EucledianDistance(this.edges[2]), this.edges[2].EucledianDistance(this.edges[0])};
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
                    if(this.edges[i].equals(otherTriangle.edges[j])){flag = 1;}
                }
                if(flag == 0){return false;} else{flag = 0;}
            }
            return true;
        }
        else{return false;}
    }

    public Point getCentre(){return super.getCentre();}
    public void setCentre(Point new_centre){super.setCentre(new_centre); this.setEdgesByCentre(this.getCentre());}
    public String getColor(){return super.getColor();}
    public void setColor(String new_c){super.setColor(new_c);}
    public boolean isFilled(){return super.isFilled();}
    public void setFilled(boolean a){super.setFilled(a);}

    public void MoveDown(){super.MoveDown();}
    public void MoveUp(){super.MoveUp();}
    public void MoveLeft(){super.MoveLeft();}
    public void MoveRight(){super.MoveRight();}
    public void MoveTo(Point p){super.MoveTo(p);}
}
