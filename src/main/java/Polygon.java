import java.util.ArrayList;
import java.util.List;

public class Polygon extends Figure{

    private List x = new ArrayList<Float>();
    private List y = new ArrayList<Float>();


    public Polygon(List x, List y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {

        float[] x1 = new float[x.size()];
        float[] y1 = new float[y.size()];

        for (int i = 0; i < x1.length; i++) {
            x1[i] = (float) x.get(i);
        }
        for (int i = 0; i < y1.length; i++) {
            y1[i] = (float) y.get(i);
        }

        int n = Math.min(x1.length, y1.length);
        if (n < 3) return 0.0;
        double a = 0.0;
        for (int i = 0; i < n; i++) {
            a += (y1[i] + y1[(i+1) % n]) * (x1[i] - x1[(i+1) % n]);
        }
        return Math.abs(a / 2.0);

    }

    @Override
    public double circumference() {

        float circumference = 0;

        for (Object floatHelp: x)
            circumference += (float) floatHelp;

        for (Object floatHelp: y)
            circumference += (float) floatHelp;

        return circumference;
    }

    @Override
    public String output() {
        return "Polygon mit " + x.size() + " Koordianten: " + "Fläche -> " + area() + ", Umfang -> " + circumference();
    }
}