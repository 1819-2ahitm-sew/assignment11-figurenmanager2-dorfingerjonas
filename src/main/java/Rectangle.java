
public class Rectangle extends Figure {

    double width;
    double length;


    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {

        return width * length;
    }

    @Override
    public double circumference() {

        return 2 * (width + length);
    }

    @Override
    public String output() {
        return "Rechteck mit Breite = " + width + " und Länge = " + length + ": " + "Fläche -> " + area() + ", Umfang -> " + circumference();
    }
}