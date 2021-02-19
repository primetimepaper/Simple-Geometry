public class Point implements Movable{
    private String color;
    public double x;
    public double y;

    public Point(){
        this.x = 0.0;
        this.y = 0.0;
        this.color = "black";
    }

    public Point(double Xcoordinate, double Ycoordinate){
        this.x = Xcoordinate;
        this.y = Ycoordinate;
        this.color = "black";
    }

    public Point(int Xcoordinate, int Ycoordinate){
        this.x = Double.valueOf(Xcoordinate);
        this.y = Double.valueOf(Ycoordinate);
        this.color = "black";
    }

    public boolean equals(Object other){
        if(other instanceof Point){
            Point otherpoint = (Point)other;
            if(this.x == otherpoint.x & this.y == otherpoint.y){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }

    public String getcolor(){
        return this.color;
    }

    public void setColor(String new_c){
        this.color = new_c;
    }

    public String toString(){
        String x = "A Point of coordinates (" + this.x + ", " + this.y + ") of color " + this.color;
        return x;
    }

    public void MoveRight(){
        this.x = this.x + 1;
    }

    public void MoveLeft(){
        this.x = this.x - 1;
    }

    public void MoveUp(){
        this.y = this.y + 1;
    }

    public void MoveDown(){
        this.y = this.y - 1;
    }

    public void MoveTo(Point p){
        this.x = p.x;
        this.y = p.y;
    }

}