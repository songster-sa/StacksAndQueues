package turtleStackOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private Pattern extract = Pattern.compile("\\(\\d+,\\s*\\d+\\)");

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        List<Turtle> turtles = loadTurtles();

        StringBuilder sb = new StringBuilder();
        for (Turtle t : turtles) {
            sb.append(", ").append(t.print());
        }
        System.out.println("Turtles: " + sb.substring(2));


        long time = System.currentTimeMillis();
        List<Turtle> stack = Solution.solve(turtles);
        time = System.currentTimeMillis() - time;

        if (!stack.isEmpty()) {
            sb = new StringBuilder();
            for (Turtle t : stack) {
                sb.append(", ").append(t.print());
            }
            System.out.println("Turtle Stack: " + sb.substring(2));
        }

        System.out.println("Valid: " + validateStack(stack));
        System.out.println("Size: " + stack.size());
        System.out.println("Time: " + time);
    }

    private List<Turtle> loadTurtles() {
        String fileName = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter Testcase filename: ");
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Turtle> turtles = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("tests/" + fileName)))) {
            String line = file.readLine();
            // comma separated (W, C) pairs

            Matcher matcher = extract.matcher(line);
            while (matcher.find()) {
                String s = matcher.group();
                // (W, C)

                String[] parts = s.trim().substring(1, s.length() - 1).split(",");

                turtles.add(new Turtle(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return turtles;
    }

    public boolean validateStack(List<Turtle> stack) {
        int totalWeight = 0;

        // Top down validation
        for (int i = stack.size() - 1; i >= 0; i--) {
            Turtle t = stack.get(i);

            if (totalWeight > t.getCapacity()) {
                // This kills the turtle
                return false;
            }

            totalWeight += t.getWeight();
        }

        // All good
        return true;
    }
}
