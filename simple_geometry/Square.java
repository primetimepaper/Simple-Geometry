package simple_geometry;

public class Square extends Rectangle{

    public Square(){
        super();
    }

    public Square(double s){
        super(s, s);
    }

    public Square(Point p, double s){
        super(s, s);
        super.setCentre(p);
    }

    public Square(double s, String c, boolean f){
        super(s, s, c, f);
    }

    public Square(Point p, double s, String c, boolean f){
        super(p, s, s, c, f);
    }

    public double getSide(){
        return super.getWidth();
    }

    public void setSide(double s){
        super.setWidth(s);
        super.setLength(s);
    }

    public String getEdges(){
        return super.getEdges();
    }

    public double getArea(){
        return super.getArea();
    }

    public double getPerimeter(){
        return super.getPerimeter();
    }

    public void MoveDown(){
        super.MoveDown();
    }

    public void MoveUp(){
        super.MoveUp();
    }

    public void MoveLeft(){
        super.MoveLeft();
    }

    public void MoveRight(){
        super.MoveRight();
    }

    public void MoveTo(Point p){
        super.MoveTo(p);
    }

    @Override
    public void setWidth(double s){
        super.setWidth(s);
        super.setLength(s);
    }
    
    @Override
    public void setLength(double s){
        super.setWidth(s);
        super.setLength(s);
    }

    @Override
    public String toString(){
        String tostr = super.toString();
        String x = "A Square with side " + this.getSide() + ", which is a subclass of " + tostr;
        return x;
    }
    @Override
    public boolean equals(Object other){
        if(other instanceof Square){
            Square otherSquare = (Square) other;
            this.getEdges();
            otherSquare.getEdges();
            for(int i = 0; i < 4; i++){
                if(!(this.edge[i].equals(otherSquare.edge[i]))){
                    return false;
                }
            }
            return true;
        }
        else{return false;}
    }

    public void Resize(double percent){
        super.Resize(percent);
    }
}
