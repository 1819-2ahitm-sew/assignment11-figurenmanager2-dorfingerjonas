import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String sortMode;
        Figure help;

        System.out.printf("Datenanzeige:%n-------------%n%n");

        System.out.println("Nach Umfang oder nach Fläche sortieren?");
        System.out.print("Geben Sie umfang/fläche ein: ");
        sortMode = scanner.nextLine();

        List <Figure> figureList = new ArrayList<Figure>();
        List<Figure> sortedList = new ArrayList<Figure>();

        figureList.add(new Rectangle(5, 20));
        figureList.add(new Square(3));
        figureList.add(new Ellipse(10, 6));
        figureList.add(new Circle(5));

//        if ((sortMode.toLowerCase()).equals("umfang")) {
//            //Nach Umfang sortieren ...
//
//            double smallest = 0;
//            Figure smallestFigure = null;
//
//            for (Figure overFigure : figureList) {
//                for (Figure figure : figureList) {
//                    if (figure.circumference() < smallest) {
//                        smallest = figure.circumference();
//                        smallestFigure = figure;
//                    }
//                }
//                sortedList.add(smallestFigure);
//            }
//
//
//
//        } else {
//            // Nach Fläche sortieren ...
//
//        }

        for (int i = 0; i < figureList.size(); i++) {
            System.out.println(figureList.get(i).output());
        }
    }
}