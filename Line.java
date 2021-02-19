public class Line implements Movable, Resizable{
    private Point start;
    private Point end;
    private String color;

    public Line(Point a, Point b){
        this.start = a;
        this.end = b;
        this.color = "black";
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String new_c){
        this.color = new_c;
    }

    public Point getStart(){
        return start;
    }

    public void setStart(Point new_start){
        this.start = new_start;
    }

    public Point getEnd(){
        return end;
    }

    public void setEnd(Point new_end){
        this.end = new_end;
    }

    public double getLength(){
        double distx = this.end.x - this.start.x;
        double disty = this.end.y - this.start.x;
        double ans = Math.sqrt(Math.pow(distx, 2) + Math.pow(disty, 2));
        return ans;
    }

    public Point getCentre(){
        double x = (this.start.x + this.end.x) / 2;
        double y = (this.start.y + this.end.y) / 2;
        Point p = new Point(x, y);
        return p;
    }

    public boolean equals(Object other){
        if(other instanceof Line){
            Line otherline = (Line)other;
            if(this.start == otherline.start & this.end == otherline.end){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }

    public String toString(){
        String x = "A Line of length " + this.getLength() + " and color " + this.color + ". It starts at " + this.start.toString() + ", and ends at " + this.end.toString();
        return x;
    }

    public void MoveRight(){
        this.start.x = this.start.x + 1;
        this.end.x = this.end.x + 1;
    }

    public void MoveLeft(){
        this.start.x = this.start.x - 1;
        this.end.x = this.end.x - 1;
    }

    public void MoveUp(){
        this.start.y = this.start.y + 1;
        this.end.y = this.end.y + 1;
    }

    public void MoveDown(){
        this.start.y = this.start.y - 1;
        this.end.y = this.end.y - 1;
    }

    public void MoveTo(Point p){
        Point oldcentre = this.getCentre();
        double xdist = oldcentre.x - p.x;
        double ydist = oldcentre.y - p.y;
        this.start.x = this.start.x - xdist;
        this.end.x = this.start.x - xdist;
        this.start.y = this.start.y - ydist;
        this.end.y = this.end.y - ydist;
    }

    @Override
    public void resize(double percent){
        if(percent > 0){
            double xdist, ydist;
            if(this.start.x > this.end.x){
                xdist = this.start.x - this.end.x;
                this.start.x += xdist * percent * 0.5;
                this.end.x -= xdist * percent * 0.5;
            } else{
                xdist = this.end.x - this.start.x;
                this.start.x -= xdist * percent * 0.5;
                this.end.x += xdist * percent * 0.5;
            }
            if(this.start.y > this.end.y){
                ydist = this.start.y - this.end.y;
                this.start.y += ydist * percent * 0.5;
                this.end.y -= ydist * percent * 0.5;
            } else{
                ydist = this.end.y - this.start.y;
                this.start.y -= ydist * percent * 0.5;
                this.end.y += ydist * percent * 0.5;
            }

        }
    }

}