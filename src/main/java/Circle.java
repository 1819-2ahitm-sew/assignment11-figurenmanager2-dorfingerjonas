public class Circle extends Figure{

    double radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {

        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double circumference() {

        return 2 * Math.PI * radius;
    }

    @Override
    public String output() {
        return "Kreis mit Radius " + radius + ": Fläche -> " + area() + ", Umfang -> " + circumference() + "";
    }
}