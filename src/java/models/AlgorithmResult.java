package models;

public class AlgorithmResult {
    private String name;
    private int steps;
    private long time;

    public AlgorithmResult(String name, int steps, long time) {
        this.name = name;
        this.steps = steps;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

    public long getTime() {
        return time;
    }

    public String toCSV() {
        return name + "," + steps + "," + time;
    }

    public static AlgorithmResult fromCSV(String line) {
        String[] data = line.split(",");
        return new AlgorithmResult(data[0], Integer.parseInt(data[1]), Long.parseLong(data[2]));
    }
}
