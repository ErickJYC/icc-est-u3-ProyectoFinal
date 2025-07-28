package dao.impl;

import dao.AlgorithmResultDAO;
import models.AlgorithmResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmResultDAOFile implements AlgorithmResultDAO {
    private final String fileName = "results.csv";

    @Override
    public void save(AlgorithmResult result) {
        List<AlgorithmResult> all = findAll();
        boolean updated = false;

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equals(result.getName())) {
                all.set(i, result); // actualiza si ya existe
                updated = true;
                break;
            }
        }

        if (!updated) {
            all.add(result); // agrega si es nuevo
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (AlgorithmResult r : all) {
                writer.println(r.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @Override
    public List<AlgorithmResult> findAll() {
        List<AlgorithmResult> list = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) return list;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(AlgorithmResult.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        return list;
    }

    @Override
    public void clear() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.print("");
        } catch (IOException e) {
            System.out.println("Error al limpiar: " + e.getMessage());
        }
    }
}
