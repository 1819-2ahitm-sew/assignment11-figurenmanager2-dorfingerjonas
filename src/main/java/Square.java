public class Square extends Figure {

    double side;


    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {

        return Math.pow(side, 2);
    }

    @Override
    public double circumference() {

        return 4 * side;
    }

    @Override
    public String output() {
        return "Quadrat mit Seitenlänge = " + side + ": " + "Fläche -> " + area() + ", Umfang -> " + circumference();
    }
}