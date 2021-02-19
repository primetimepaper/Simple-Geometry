public class Square extends Rectangle{

    public Square(){
        super();
    }

    public Square(double s){
        super.setWidth(s);
        super.setLength(s);
    }

    public Square(Point p, double s){
        super.setWidth(s);
        super.setLength(s);
        super.centre = p;
    }

    public Square(double s, String c, boolean f){
        super.setWidth(s);
        super.setLength(s);
        super.setColor(c);
        super.setFilled(f);
    }

    public Square(Point p, double s, String c, boolean f){
        super.setWidth(s);
        super.setLength(s);
        super.setColor(c);
        super.setFilled(f);
        super.centre = p;
    }

    public double getSide(){
        return super.getWidth();
    }

    public void setSide(double s){
        super.setWidth(s);
        super.setLength(s);
    }

    @Override
    public void setWidth(double s){
        super.setWidth(s);
        super.setLength(s);
    }

    public void setLength(double s){
        super.setWidth(s);
        super.setLength(s);
    }

    public String toString(){
        String tostr = super.toString();
        String x = "A Square with side " + this.getSide() + ", which is a subclass of " + tostr;
        return x;
    }

    public void resize(double percent){
        super.resize(percent);
    }
}