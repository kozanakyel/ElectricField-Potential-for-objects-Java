import org.opensourcephysics.frames.Scalar2DFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author : Uğur AKYEL
 * @since  : 27/04/2020
 **/

public class ElectricityApp {
    public static void main(String[] args){
        System.out.println("\n* Question 1)Assume 8 charges locations and nano Coulomb value are; \n" +
                "               2Q (-8,2), -Q (-3,-2), -4Q (-5,2), 3Q (-3, 3), 2Q (1,-2), \n" +
                "               -3Q (4, 2), Q (6, -1), -3Q (2, 2). What is the total electric Potential\n" +
                "               At the (0,0) ?");

        Charge charge1 = new Charge(-8,2,2,"nano");
        Charge charge2 = new Charge(-3,-2,-1,"nano");
        Charge charge3 = new Charge(-5,2,4,"nano");
        Charge charge4 = new Charge(-3,3,3,"nano");
        Charge charge5 = new Charge(1,-2,2,"nano");
        Charge charge6 = new Charge(4,2,-3,"nano");
        Charge charge7 = new Charge(6,-1,1,"nano");
        Charge charge8 = new Charge(2,2,-3,"nano");
        ArrayList<Charge> chargeList = new ArrayList<>();
        chargeList.add(charge1);
        chargeList.add(charge2);
        chargeList.add(charge3);
        chargeList.add(charge4);
        chargeList.add(charge5);
        chargeList.add(charge6);
        chargeList.add(charge7);
        chargeList.add(charge8);
        
        double result1 = 0;
        for(int i = 0; i < chargeList.size(); i++){
            result1 += chargeList.get(i).potentialAt(0,0);
        }
        System.out.printf("\n Answer 1)\n    Total electric Potential of 8 charges is: " +
                "%.2f Volt at the (0,0) \n", result1);

        System.out.println("\n* Question 2) Assume two charges are located (-7, 0) and (4,0),\n" +
                "          their micro Coulomb values are -2Q and 4Q respectively,\n" +
                "          i) Which points Electric Potential is zero?\n" +
                "          ii) What is the first charges Electric Field Vector magnitude and Angle\n" +
                "                 at the (0,0)?\n" +
                "          iii) What is the two charges Electric Field Vector magnitude\n" +
                "                 at the (4,4)?");
        Charge charge9 = new Charge(-7,0,-2,"micro");
        Charge charge10 = new Charge(4,0,4,"micro");
        ArrayList<String> pointList = new ArrayList<>();
        for(int i = -20; i < 30; i++){
            for(int j = -20; j < 30; j++){
                double result2 = charge9.potentialAt(i,j)
                        + charge10.potentialAt(i,j);
                if(result2 == 0.0){
                    pointList.add("at the (" + i + ", " + j + ")");
                }
            }
        }
        System.out.println("\n Answer 2)\n  i) Zero potential points are: ");
        for(int i = 0; i < pointList.size(); i++)
            System.out.println("    "+(i+1) + ") " + pointList.get(i));


        System.out.printf("   ii) First charges Electric Vector Magnitude is:"
                        + " %.3f N/C \n    and the angle is: "
                        + "%.2f degree at the (0,0) ", charge9.eFieldVectorMagnitude(0,0),
                charge9.eFieldVectorAngle(0,0));

        System.out.print("\n   iii) ");
        charge9.eFieldVectorAdd(charge10,0,0);

        System.out.println("\n* Question 3) Assume a Conducting Sphere is located at the \n" +
                "                (0,0) its radius 6 cm and  its charge 5Q nano Coulomb,\n" +
                "                i) What is the Potential and electric Field Vector \n" +
                "                      magnitude at the (2,4)\n" +
                "                ii) What is the Potential and electric field Vector\n" +
                "                      magnitude at the (6,0)\n" +
                "                iii) What is the Potential and Electric field Vector\n" +
                "                      magnitude at the (8,-8)");
        ConductingSphere conductingSphere1 = new ConductingSphere(0,0,6,5,"nano");

        double potInside = conductingSphere1.potentialAt(2,4);
        System.out.println(" Answer 3)\n  i)Conducting sphere inside potential is: " + potInside + " at the (2,4)");
        try{
            double efieldInside = conductingSphere1.eFieldVectorMagnitude(2,4);
        }catch(NotFoundElectricField ex){
            System.out.println(ex + " at the (2,4) for This Conductor Sphere");
        }


        double potSurface = conductingSphere1.potentialAt(6,0);
        double elFiVector = conductingSphere1.eFieldVectorMagnitude(6,0);
        System.out.printf("   ii)This Conducting sphere surface potential value is %.3f Volt and \n" +
                "the electric vector magnitude is %.3f N/C at the (6,0)", potSurface, elFiVector);


        double potSurface1 = conductingSphere1.potentialAt(8,-8);
        double elFiVector1 = conductingSphere1.eFieldVectorMagnitude(8,-8);
        System.out.printf("\n   iii)This Conducting sphere outside potential value is %.3f Volt and \n" +
                "the electric vector magnitude is %.3f N/C at the (8,-8) ", potSurface1, elFiVector1);

        System.out.println("\n\n* Question 4) Assume a Insulating Sphere is located at the \n" +
                "           (2,2) its radius 3 cm and its charge -3Q micro Coulomb, \n" +
                "             i) What is the potential and electric field vector \n" +
                "               magnitude at the (3,3)\n" +
                "             ii) What is the potential and the electric field vector \n" +
                "               magnitude at the (5,2)\n" +
                "             iii) What is the potential and the electric field vector \n" +
                "               magnitude at the (7,7)?");
        InsulatingSphere insulatingSphere1 = new InsulatingSphere(2,2,3,-3, "micro");

        double potInside1 = insulatingSphere1.potentialAt(3,3);
        double eFielVec1 = insulatingSphere1.eFieldVectorMagnitude(3,3);
        System.out.printf("\n Answer 4)\n  i)This Insulating sphere inside potential value is %.3f Volt and \n" +
                "the electric vector magnitude is %.3f N/C at the (3,3)", potInside1, eFielVec1);


        double potInside2 = insulatingSphere1.potentialAt(5,2);
        double eFielVec2 = insulatingSphere1.eFieldVectorMagnitude(5,2);
        System.out.printf("\n   ii)This Insulating sphere surface potential value is %.3f Volt and \n" +
                "the electric vector magnitude is %.3f N/C at the (5,2) ", potInside2, eFielVec2);


        double potInside3 = insulatingSphere1.potentialAt(7,7);
        double eFielVec3 = insulatingSphere1.eFieldVectorMagnitude(7,7);
        System.out.printf("\n   iii)This Insulating sphere outside potential value is %.3f Volt and \n" +
                "the electric vector magnitude is %.3f N/C at the (7,7) ", potInside3, eFielVec3);

        System.out.println("\n\n* Question 5) Assume that a charge is located at the (8,2) and its \n" +
                "               micro Coulomb value is -4Q, a Conducting sphere is located at the \n" +
                "               (-5, -6) and its nano coulomb value is 30Q its radius 2 cm, \n" +
                "               an Insulating sphere is located at the (3,-10) its radius 3cm\n" +
                "               and its nano Coulomb value 12Q,\n" +
                "             What is the total potential at the origin ? ");

        Charge charge55 = new Charge(8,2,-4,"micro");
        ConductingSphere conductingSphere55 = new ConductingSphere(-5,-6,2,30,"nano");
        InsulatingSphere insulatingSphere55 = new InsulatingSphere(3,-10,3,12,"nano");
        double result55 = charge55.potentialAt(0,0)
                + conductingSphere55.potentialAt(0,0)
                + insulatingSphere55.potentialAt(0,0);
        System.out.printf("\n   Answer-5) Total potential is %.3f Volt at the (0,0)", result55);

        double KQ_NANO_COULOMB = 9;
        Charge charge111 = new Charge(0,0,2,"nano");
        Charge charge222 = new Charge(10,0,-1,"nano");

        Scalar2DFrame frame = new Scalar2DFrame("x","y","Electric Potential surface");
        double[][] data = new double[20][20];
        frame.setAll(data,-10,20,-10,10);
        double xs1 = charge222.getX(), ys1 = charge222.getY();
        double xs = charge111.getX(), ys = charge111.getY();
        for(int ix = 0; ix < 20; ix++){
            double x = frame.indexToX(ix);
            double dx = (xs - x);
            double dx1 = (xs1 - x);
            for(int iy = 0; iy < 20; iy++){
                double y = frame.indexToY(iy);
                double dy = (ys - y);
                double dy1 = (ys1 - y);
                double r2 = dx * dx + dy * dy;
                double r = Math.sqrt(r2);
                double r3 = dx1 * dx1 + dy1 * dy1;
                double r4 = Math.sqrt(r3);
                data[ix][iy] += charge111.potentialAt(dx,dy) +
                        ((charge222.getQ()*KQ_NANO_COULOMB)/r4)*100;
            }
        }
        frame.setAll(data);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

interface IElectric{
    double KQ_NANO_COULOMB = 9;
    double KQ_MICRO_COULOMB = 9000;

    double eFieldVectorMagnitude(double x, double y);
    double potentialAt(double x, double y);
}

abstract class MyPoint{
    private double x;
    private double y;

    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
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

    public abstract double distance(double x, double y);

    public String toString(){
        return "at the (" + this.getX() + ", " + this.getY() + ")";
    }
}

class Charge extends MyPoint implements IElectric{
    private int q;
    private String coulombValue;

    public Charge(double x, double y, int q, String coulombValue) {
        super(x, y);
        this.q = q;
        this.coulombValue = coulombValue;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public String getCoulombValue() {
        return coulombValue;
    }

    public void setCoulombValue(String coulombValue) throws InvalidCoulombValue{
        if(coulombValue.compareTo("nano") == 0 || coulombValue.compareTo("micro") == 0){
            this.coulombValue = coulombValue;
        }
        else
            throw new InvalidCoulombValue(coulombValue);
    }

    @Override
    public double distance(double x, double y){
        double dx = x - this.getX();
        double dy = y - this.getY();
        return Math.sqrt((Math.pow(dx, 2) + Math.pow(dy, 2)));
    }

    @Override
    public double potentialAt(double x, double y){
        if(getCoulombValue().compareTo("nano") == 0) {
            return ((KQ_NANO_COULOMB * this.getQ()) / this.distance(x, y)) * 100;
        }
        else
            return ((KQ_MICRO_COULOMB * this.getQ()) / this.distance(x, y)) * 100;
    }

    @Override
    public double eFieldVectorMagnitude(double x, double y){
        if(getCoulombValue().compareTo("nano") == 0) {
            return ((this.getQ() * KQ_NANO_COULOMB) / Math.pow(distance(x, y), 2)) * 1000;
        }
        else
            return ((this.getQ() * KQ_MICRO_COULOMB) / Math.pow(distance(x, y), 2)) * 1000;
    }

    public double eFieldVectorAngle(double x, double y) throws NotFoundAngleException{
        double dy = x - getY();
        double dx = y - getX();
        if(dx != 0)
            return Math.toDegrees(Math.atan(dy/dx));
        else{
            if(dy > 0)
                return 90;
            else if(dy < 0)
                return 270;
            else
                throw new NotFoundAngleException(dx);
        }
    }

    public void eFieldVectorAdd(Charge c1, double x, double y) throws NotFoundAngleException{
        double dx1 = Math.cos(this.eFieldVectorAngle(x,y)) * this.eFieldVectorMagnitude(x,y);
        double dx2 = Math.cos(c1.eFieldVectorAngle(x,y)) * c1.eFieldVectorMagnitude(x,y);
        double dy1 = Math.sin(this.eFieldVectorAngle(x,y)) * this.eFieldVectorMagnitude(x,y);
        double dy2 = Math.sin(c1.eFieldVectorAngle(x,y)) * c1.eFieldVectorMagnitude(x,y);
        double fieldVectorMagnitude = Math.sqrt(Math.pow((dx2-dx1),2) + Math.pow((dy2-dy1),2));
        double fieldVectorAngle = Math.toDegrees(Math.atan((dy2-dy1)/(dx2-dx1)));
        System.out.printf(toString() + " and " + c1.toString() +
                " \n    create an Electric Field Vector that's magnitude %.3f  N/C and\n    the angle is" +
                " %.3f \n",fieldVectorMagnitude, fieldVectorAngle);
    }

    public String toString(){
        return getQ() + "Q " + getCoulombValue() + " Coulomb " + super.toString();
    }
}

class Sphere extends MyPoint{
    private double radius;

    public Sphere(double x, double y, double radius) throws NotNegativeRadiusException{
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws NotNegativeRadiusException {
        if(radius > 0){
            this.radius = radius;
        }else
            throw new NotNegativeRadiusException();
    }

    public double getSurfaceArea(){
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume(){
        return (4 * Math.PI * radius * radius * radius) / 3;
    }

    @Override
    public double distance(double x, double y){
        double dx = x - this.getX();
        double dy = y - this.getY();
        return Math.sqrt((Math.pow(dx, 2) + Math.pow(dy, 2)));
    }

    public String toString(){
        return "This sphere radius: " + getRadius() + super.toString();
    }
}

class ConductingSphere extends Sphere implements IElectric{
    private int q;
    private String coulombValue;

    public ConductingSphere(double x, double y, double radius, int q,
                            String coulombValue) throws InvalidCoulombValue{
        super(x, y, radius);
        this.q = q;
        this.coulombValue = coulombValue;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public String getCoulombValue() {
        return coulombValue;
    }

    public void setCoulombValue(String coulombValue) throws InvalidCoulombValue {
        if(coulombValue.compareTo("nano") == 0 || coulombValue.compareTo("micro") == 0){
            this.coulombValue = coulombValue;
        }
        else
            throw new InvalidCoulombValue(coulombValue);
    }

    @Override
    public double eFieldVectorMagnitude(double x, double y) throws NotFoundElectricField{
        double distanceR = distance(x,y);
        if(distanceR < getRadius()){
            throw new NotFoundElectricField();
        }
        else if(distanceR == getRadius() && getCoulombValue().compareTo("nano") == 0){
            return ((this.getQ() * KQ_NANO_COULOMB) / Math.pow(getRadius(), 2)) * 1000;
        }
        else if(distanceR == getRadius() && getCoulombValue().compareTo("micro") == 0){
            return ((this.getQ() * KQ_MICRO_COULOMB) / Math.pow(getRadius(), 2)) * 1000;
        }
        else if(distanceR > getRadius() && getCoulombValue().compareTo("micro") == 0){
            return ((this.getQ() * KQ_MICRO_COULOMB) / Math.pow(distanceR, 2)) * 1000;
        }
        else{
            return ((this.getQ() * KQ_NANO_COULOMB) / Math.pow(distanceR, 2)) * 1000;
        }
    }

    @Override
    public double potentialAt(double x, double y) {
        double distanceR = distance(x,y);
        boolean distanceRmin = distanceR <= getRadius();
        boolean distanceRmax = distanceR > getRadius();

        if(distanceRmin && getCoulombValue().compareTo("nano") == 0){
            return ((KQ_NANO_COULOMB * this.getQ()) / getRadius()) * 100;
        }
        else if(distanceRmin && getCoulombValue().compareTo("micro") == 0){
            return ((KQ_MICRO_COULOMB * this.getQ()) / getRadius()) * 100;
        }
        else if(distanceRmax && getCoulombValue().compareTo("nano") == 0){
            return ((KQ_NANO_COULOMB * this.getQ()) / distanceR) * 100;
        }
        else
            return ((KQ_MICRO_COULOMB * this.getQ()) / distanceR) * 100;
    }

    public String toString(){
        return "This Conducting Sphere has " + getQ() + "Q " +
                getCoulombValue() + " Coulomb" + super.toString();
    }
}

class InsulatingSphere extends Sphere implements IElectric{
    private int q;
    private String coulombValue;

    public InsulatingSphere(double x, double y, double radius,
                            int q, String coulombValue) throws InvalidCoulombValue{
        super(x, y, radius);
        this.q = q;
        this.coulombValue = coulombValue;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public String getCoulombValue() {
        return coulombValue;
    }

    public void setCoulombValue(String coulombValue) throws InvalidCoulombValue {
        if(coulombValue.compareTo("nano") == 0 || coulombValue.compareTo("micro") == 0){
            this.coulombValue = coulombValue;
        }
        else
            throw new InvalidCoulombValue(coulombValue);
    }

    public double getChargeDensity(){
        return getQ() / getVolume();
    }

    public double getQin(double x, double y){
        Sphere gaussianSurface = new Sphere(getX(),getY(), distance(x,y));

        return getChargeDensity() * gaussianSurface.getVolume();
    }

    @Override
    public double eFieldVectorMagnitude(double x, double y){
        double distanceR = distance(x,y);
        if(distanceR < getRadius() && getCoulombValue().compareTo("nano") == 0){
            return ((getQin(x,y) * KQ_NANO_COULOMB) / Math.pow(distanceR, 2)) * 1000;
        }
        else if(distanceR < getRadius() && getCoulombValue().compareTo("micro") == 0){
            return ((getQin(x,y) * KQ_MICRO_COULOMB) / Math.pow(getRadius(), 2)) * 1000;
        }
        else if(distanceR == getRadius() && getCoulombValue().compareTo("nano") == 0){
            return ((this.getQ() * KQ_NANO_COULOMB) / Math.pow(getRadius(), 2)) * 1000;
        }
        else if(distanceR == getRadius() && getCoulombValue().compareTo("micro") == 0){
            return ((this.getQ() * KQ_MICRO_COULOMB) / Math.pow(getRadius(), 2)) * 1000;
        }
        else if(distanceR > getRadius() && getCoulombValue().compareTo("micro") == 0){
            return ((this.getQ() * KQ_MICRO_COULOMB) / Math.pow(distanceR, 2)) * 1000;
        }
        else{
            return ((this.getQ() * KQ_NANO_COULOMB) / Math.pow(distanceR, 2)) * 1000;
        }
    }

    @Override
    public double potentialAt(double x, double y) {
        double distanceR = distance(x,y);

        if(distanceR < getRadius() && getCoulombValue().compareTo("nano") == 0){
            return ((KQ_NANO_COULOMB * getQin(x,y)) / distanceR) * 100;
        }
        else if(distanceR < getRadius() && getCoulombValue().compareTo("micro") == 0){
            return ((KQ_MICRO_COULOMB * getQin(x,y)) / distanceR) * 100;
        }
        else if(distanceR >= getRadius() && getCoulombValue().compareTo("nano") == 0){
            return ((KQ_NANO_COULOMB * this.getQ()) / distanceR) * 100;
        }
        else
            return ((KQ_MICRO_COULOMB * this.getQ()) / distanceR) * 100;
    }

    public String toString(){
        return "This Insulating Sphere has " + getQ() + "Q " +
                getCoulombValue() + " Coulomb" + super.toString();
    }
}

class NotFoundAngleException extends RuntimeException{
    private double angle;

    public NotFoundAngleException(double angle) {
        this.angle = angle;
    }

    public String toString(){
        return "This is not angle! it is a point. (0,0)";
    }
}

class InvalidCoulombValue extends RuntimeException{
    private String coulombValue;

    public InvalidCoulombValue(String coulombValue) {
        this.coulombValue = coulombValue;
    }

    public String toString(){
        return "this coulomb value not nano or micro";
    }
}

class NotFoundElectricField extends RuntimeException{
    public NotFoundElectricField(){

    }

    public String toString(){
        return "Electric Field does not exist!";
    }
}

class NotNegativeRadiusException extends RuntimeException{
    public NotNegativeRadiusException(){

    }

    public String toString(){
        return "Radius must not be negative";
    }
}

