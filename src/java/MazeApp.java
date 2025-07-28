import controllers.MazeController;
import models.Cell;
import models.SolveResults;
import solver.MazeSolver;
import solver.impl.MazeSolverBFS;

public class MazeApp {
    public static void main(String[] args) {
        boolean[][] laberinto = {
                { true, true, false, true },
                { false, true, false, true },
                { true, true, true, true },
                { false, false, true, true }
        };

        Cell inicio = new Cell(0, 0);
        Cell fin = new Cell(3, 3);

        MazeSolver solucionador = new MazeSolverBFS();
        MazeController controlador = new MazeController(solucionador);

        SolveResults resultado = controlador.resolverLaberinto(laberinto, inicio, fin);

        System.out.println("Camino:");
        if (!resultado.getCaminos().isEmpty()) {
            for (Cell c : resultado.getCaminos().get(0)) {
                System.out.println("(" + c.getRow() + "," + c.getCol() + ")");
            }
        }

        System.out.println("\nVisitadas:");
        if (!resultado.getVisitados().isEmpty()) {
            for (Cell c : resultado.getVisitados().get(0)) {
                System.out.println("(" + c.getRow() + "," + c.getCol() + ")");
            }
        }
    }
}
