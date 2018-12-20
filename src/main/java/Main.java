import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sortMode;

        System.out.printf("Figurenmanager 2:%n-----------------%n");

        List<Figure> figureList = new ArrayList<Figure>();

        do {
            printMenu();
            sortMode = scanner.nextInt();
            menuMethods(sortMode,figureList);
        } while (sortMode != 6);
    }

    private static void printMenu() {
        System.out.println("\n0 - newFigure");
        System.out.println("1 - sortCircumference");
        System.out.println("2 - sortArea");
        System.out.println("3 - deleteFigure");
        System.out.println("4 - printFigures");
        System.out.println("5 - countInstances");
        System.out.println("6 - Quit");
        System.out.println("=====================");
    }

    private static void menuMethods(int sortMode, List<Figure> figureList) {
        switch (sortMode) {
            case 0: newFigure(figureList);
                break;
            case 1: sortCircumference(figureList);
                break;
            case 2: sortArea(figureList);
                break;
            case 3: deleteFigures(figureList);
                break;
            case 4: printFigures(figureList);
                break;
            case 5: countInstances(figureList);
                break;
            case 6: quit();
                break;
            default: printErrMessage();
        }
    }

    private static void countInstances(List<Figure> figureList) {
        int circleCount = 0;
        int rectCount = 0;
        int squareCount = 0;
        int ellipseCount = 0;
        int polygonCount = 0;

        if (figureList.size() != 0) {
            for (Figure figure : figureList) {
                if (figure instanceof Circle)
                    circleCount++;
                else if (figure instanceof Rectangle)
                    rectCount++;
                else if (figure instanceof Square)
                    squareCount++;
                else if (figure instanceof Ellipse)
                    ellipseCount++;
                else if (figure instanceof Polygon)
                    polygonCount++;
            }

            if (rectCount == 1)
                System.out.println( rectCount + " Rechteck wurde erstellt!");
            else if (rectCount > 1)
                System.out.println(rectCount + " Rechtecke wurden erstellt!");

            if (squareCount == 1)
                System.out.println( squareCount + " Quadrat wurde erstellt!");
            else if (squareCount > 1)
                System.out.println( squareCount + " Quadrate wurden erstellt!");

            if (circleCount == 1)
                System.out.println( circleCount + " Kreis wurde erstellt!");
            else if (circleCount > 1)
                System.out.println( circleCount + " Kreise wurden erstellt!");

            if (ellipseCount == 1)
                System.out.println( ellipseCount + " Ellipse wurde erstellt!");
            else if (ellipseCount > 1)
                System.out.println( ellipseCount + " Ellipsen wurden erstellt!");

            if (polygonCount == 1)
                System.out.println( polygonCount + " Polygon wurde erstellt!");
            else if (polygonCount > 1)
                System.out.println( polygonCount + " Polygone wurde erstellt!");
        } else {
            System.err.println("Es wurden noch keine Figuren erstellt!");
        }
    }

    private static void quit() {
        System.out.println("Auf Wiedersehen!");
    }

    private static void deleteFigures(List<Figure> figureList) {
        Scanner scanner = new Scanner(System.in);
        int index;

        System.out.println();
        System.out.println("Index of Figure:");
        index = scanner.nextInt();
        System.out.println();
        figureList.remove(index);
    }

    private static void newFigure(List<Figure> figureList) {
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.println();
        System.out.println("Figur:");
        System.out.println("0 - Rectangle");
        System.out.println("1 - Quadrat");
        System.out.println("2 - Circle");
        System.out.println("3 - Ellipse");
        System.out.println("4 - Polygon");
        System.out.println("-------------");
        input = scanner.nextInt();

        switch (input) {
            case 0:
                int length;
                int width;

                System.out.println("\nRechteck");
                System.out.println("------------");
                System.out.print("Länge: ");
                length = scanner.nextInt();
                System.out.print("Breite: ");
                width = scanner.nextInt();

                figureList.add(new Rectangle(length, width));

                break;
            case 1:
                int side;

                System.out.println("\nQuadrat");
                System.out.println("------------");
                System.out.print("Seitenlänge: ");
                side = scanner.nextInt();

                figureList.add(new Square(side));
                break;
            case 2:
                int radius;

                System.out.println("\nKreis");
                System.out.println("------------");
                System.out.print("Radius: ");
                radius = scanner.nextInt();

                figureList.add(new Circle(radius));
                break;
            case 3:
                int mainaxis;
                int secondaxis;

                System.out.println("\nEllipse");
                System.out.println("------------");
                System.out.print("Hauptachse: ");
                mainaxis = scanner.nextInt();
                System.out.print("Nebenachse: ");
                secondaxis = scanner.nextInt();

                figureList.add(new Ellipse(mainaxis, secondaxis));
                break;
            case 4:
                List<Float> x = new ArrayList<Float>();
                List<Float> y = new ArrayList<Float>();

                int counter = 1;
                float xInput;
                float yInput;

                System.out.println("\nPolygon");
                System.out.println("------------");
                System.out.println("Geben Sie '-1' ein um die Eingabe abbzubrechen");
                System.out.println();
                do {
                    System.out.print(counter + ". X Koordinate: ");
                    xInput = scanner.nextFloat();

                    System.out.print(counter + ". Y Koordinate: ");
                    yInput = scanner.nextFloat();
                    counter++;

                    if (xInput != 0)
                    x.add(xInput);
                    System.out.println(x);

                    if (yInput != 0)
                        y.add(yInput);
                    System.out.println(y);
                } while (xInput == -1 || yInput == -1);

                figureList.add(new Polygon(x, y));

                break;

        }
        System.out.println();
    }

    private static void printErrMessage() {
        System.err.println("Ungültige Eingabe!");
    }

    private static void printFigures(List<Figure> figureList) {

        CurrentMode cm = new CurrentMode();

        if (figureList.size() == 0) {
            System.err.println("Es wurden noch keine Figuren erstellt!");
        } else {
            if (!(cm.getCurrMode())) {

                List<String> sortedList = sortCircumference(figureList);

                for (String str : sortedList)
                    System.out.println(str);
            } else if (cm.getCurrMode()) {

                List<String> sortedList = sortArea(figureList);

                for (String str : sortedList)
                    System.out.println(str);
            }
        }
    }

    private static List<String> sortCircumference(List<Figure> figureList) {

        CurrentMode cm = new CurrentMode();

        cm.setCurrMode(false);

        List<String> sortedList = new ArrayList<String>();
        Collections.sort(figureList, new Comparator<Figure>() {

            @Override
            public int compare(Figure o1, Figure o2) {
                return Double.compare(o1.circumference(), o2.circumference());
            }
        });

        for (Figure figure : figureList)
            sortedList.add(figure.output());

        return sortedList;
    }

    private static List<String> sortArea(List<Figure> figureList) {

        CurrentMode cm = new CurrentMode();

        cm.setCurrMode(true);

        List<String> sortedList = new ArrayList<String>();
        Collections.sort(figureList, new Comparator<Figure>() {

            @Override
            public int compare(Figure o1, Figure o2) {
                return Double.compare(o1.area(), o2.area());
            }
        });

        for (Figure figure : figureList)
            sortedList.add(figure.output());

        return sortedList;
    }
}