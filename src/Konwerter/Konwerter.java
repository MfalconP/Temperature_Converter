package Konwerter;

public class Konwerter {
    private static final double przelicznik = 1.8;

    public static double cToF(double c){
        double f = (przelicznik*c) + 32;
        return f;
    }
    public static double fToC(double f){
        double c = (f-32)/przelicznik;
        return c;
    }
}
