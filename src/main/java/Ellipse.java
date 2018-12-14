public class Ellipse extends Figure{

    double mainaxis;
    double secondaxis;


    public Ellipse(int mainaxis, double secondaxis) {
        this.mainaxis = mainaxis;
        this.secondaxis = secondaxis;
    }

    @Override
    public double area() {

        return Math.PI * mainaxis * secondaxis;
    }

    @Override
    public double circumference() {
        double lambda;

        lambda = (mainaxis - secondaxis) / (mainaxis + secondaxis);

        return (mainaxis + secondaxis) * Math.PI * (1 + ((3 * lambda * lambda)) / (10 + Math.sqrt(4 - 3 * lambda * lambda)));
    }

    @Override
    public String output() {
        return "Ellipse mit Hauptachse = " + mainaxis + " und Nebenachse = " + secondaxis + ": " + "Fläche -> " + area() + ", Umfang -> " + circumference();
    }
}