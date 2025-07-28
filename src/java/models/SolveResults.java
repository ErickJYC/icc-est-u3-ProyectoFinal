package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SolveResults {
    private List<AlgorithmResult> list;

    public SolveResults() {
        list = new ArrayList<>();
    }

    public void add(AlgorithmResult result) {
        list.add(result);
    }

    public List<AlgorithmResult> getList() {
        return list;
    }
}
