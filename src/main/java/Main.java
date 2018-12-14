import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sortMode;

        System.out.printf("Datenanzeige:%n-------------%n");

        List<Figure> figureList = new ArrayList<Figure>();

        do {
            printMenu();
            sortMode = scanner.nextInt();
            run(sortMode,figureList);
        } while (sortMode != 5);

    }

    private static void printMenu() {
        System.out.println("\n0 - newFigure");
        System.out.println("1 - sortCircumference");
        System.out.println("2 - sortArea");
        System.out.println("3 - deleteFigure");
        System.out.println("4 - printFigures");
        System.out.println("5 - Quit");
        System.out.println("================");
    }

    private static void run(int sortMode, List<Figure> figureList) {
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
            case 5: quit();
                break;
            default: printErrMessage();
        }
    }

    private static void quit() {
        System.out.println("Auf Wiedersehen!");
    }

    private static void deleteFigures(List<Figure> figureList) {
        Scanner scanner = new Scanner(System.in);
        int index;

        System.out.println();
        System.out.println("Index of Figure");
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
        System.out.println("-------------");
        input = scanner.nextInt();

        switch (input) {
            case 0:
                int length;
                int width;

                System.out.println("\nRechteck");
                System.out.println("------------------------------------");
                System.out.print("Länge: ");
                length = scanner.nextInt();
                System.out.print("Breite: ");
                width = scanner.nextInt();

                figureList.add(new Rectangle(length, width));

                break;
            case 1:
                int side;

                System.out.println("\nQuadrat");
                System.out.println("------------------------------------");
                System.out.print("Seitenlänge: ");
                side = scanner.nextInt();

                figureList.add(new Square(side));
                break;
            case 2:
                int radius;

                System.out.println("\nKreis");
                System.out.println("------------------------------------");
                System.out.print("Radius: ");
                radius = scanner.nextInt();

                figureList.add(new Circle(radius));
                break;
            case 3:
                int mainaxis;
                int secondaxis;

                System.out.println("\nEllipse");
                System.out.println("------------------------------------");
                System.out.print("Hauptachse: ");
                mainaxis = scanner.nextInt();
                System.out.print("Nebenachse: ");
                secondaxis = scanner.nextInt();

                figureList.add(new Ellipse(mainaxis, secondaxis));
                break;
        }
        System.out.println();
    }

    private static void printErrMessage() {
        System.err.println("==================");
        System.err.println("Ungültige Eingabe!");
        System.err.println("==================");
    }

    private static void printFigures(List<Figure> figureList) {

        CurrentMode cm = new CurrentMode();

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