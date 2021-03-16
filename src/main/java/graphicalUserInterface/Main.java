package graphicalUserInterface;

import graphicalUserInterface.Controller;
import graphicalUserInterface.Model;
import graphicalUserInterface.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model,view);
    }
}
