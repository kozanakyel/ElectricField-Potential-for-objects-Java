package sample;

public class Wire{
    /*
     * muZero değerinin görülmesi için grafikte "Tesla/100000" ifadesi
     * kullanılacaktır. Çünkü muZero ifadesinin sayısal karşılığını
     * grafikte okutmak sıkıntılı bu şekilde daha anlaşılabilir
     * */
    static final double muZero = 4 * Math.PI / 100;
    private double iAmpere;
    private double x;
    private double y;
    private double radius;

    public Wire(double iAmpere, double x, double y, double radius) {
        this.iAmpere = iAmpere;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double distance(double x, double y){
        double distX = getX() - x;
        double distY = getY() - y;
        return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
    }

    public double iDensity(double x, double y){
        if(distance(x, y) >= getRadius())
            throw new InvalidDistanceException(x,y,this);
        return (Math.pow(distance(x, y), 2) * getIAmpere())
                / Math.pow(getRadius(), 2);
    }

    public double magBField(double x, double y){
        if(distance(x, y) >= getRadius())
            return (muZero * getIAmpere()) / (2 * Math.PI * distance(x, y));
        else
            return (muZero * iDensity(x, y)) / (2 * Math.PI * distance(x, y));
    }

    public double getIAmpere() {
        return iAmpere;
    }

    public void setIAmpere(double iAmpere) {
        this.iAmpere = iAmpere;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class InvalidDistanceException extends RuntimeException{
    private double x;
    private double y;
    private Wire wireI;

    public InvalidDistanceException(double x, double y, Wire wireI) {
        this.x = x;
        this.y = y;
        this.wireI = wireI;
    }

    public String toString(){
        return "The distance is much more than this wire's " +
                "radius.\nThe radius: " + (float)wireI.getRadius() +
                "\nThe distance: " + (float)wireI.distance(x, y);
    }
}