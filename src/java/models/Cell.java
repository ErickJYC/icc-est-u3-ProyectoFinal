package models;

public class Cell {
    public int row;
    public int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "(" + row + "," + col + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;
            return this.row == other.row && this.col == other.col;
        }
        return false;
    }

    public int hashCode() {
        return row * 31 + col;
    }
}
