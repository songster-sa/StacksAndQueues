package turtleStackOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * you have n turtles with weight and height defined.
 * a turtle can take as much weight on top of it as its strength
 * find out max number of turtles you can stack on top of each other without cracking its shell
 * Example: input is [W,S]
 * <p>
 * Input : [1,2] [1,1] [2,1] [2,2]
 * Output : 3 [2,2] [1,2] [1,1] - stack from bottom up order
 * <p>
 * Input : [1,1] [2,3] [4,2] [2,2]
 * Output : 3 [2,3] [2,2] [1,1] - stack from bottom up order
 * <p>
 * Input : [1,1] [2,2] [5,5] [1,6] - answer is 2 but the actual stack would be 11 55 on 16
 * but this algo would give 22 11 on 16
 */

public class Solution {

    public static List<Turtle> solve(List<Turtle> turtles) {
        List<Turtle> toReturn = new ArrayList<>();

        if (turtles.isEmpty()) {
            return toReturn;
        }

        // get the max strength
        int i = getIndexOfMaxStrength(turtles);
        toReturn.add(turtles.get(i));
        int maxStrength = turtles.get(i).getCapacity();
        turtles.remove(i);

        List<Turtle> turtlesByW = new ArrayList<>();
        turtlesByW.addAll(turtles); // ascending order
        Collections.sort(turtlesByW, new Comparator<Turtle>() {
            @Override
            public int compare(Turtle o1, Turtle o2) {
                return ((Integer) o1.getWeight()).compareTo(o2.getWeight());
            }
        });

        // System.out.println("turtles by ascending order of weight : " + turtlesByW);

        List<Turtle> stackTurtles = new ArrayList<>();
        for (Turtle item : turtlesByW) {
            if (maxStrength >= item.getWeight()) {
                // will this always work?
                // the number of turtles are same/right but the actual stack may not be
                // because the remained of the subtraction may not be found in next try
                stackTurtles.add(item);
                maxStrength = maxStrength - item.getWeight();
            }
        }

        // System.out.println("all possible turtles in stack : " + stackTurtles);

        // System.out.println("total number of possible turtles in stack = " + (stackTurtles.size() + 1));

        // prepare stack
        Comparator desc = Collections.reverseOrder(new Comparator<Turtle>() {
            @Override
            public int compare(Turtle o1, Turtle o2) {
                return ((Integer) o1.getCapacity()).compareTo(o2.getCapacity());
            }
        });
        Collections.sort(stackTurtles, desc); // descending order
        toReturn.addAll(stackTurtles);

        // System.out.println("final stack (bottom to top)= " + toReturn);

        return toReturn;
    }

    private static int getIndexOfMaxStrength(List<Turtle> turtles) {
        int maxIndex = 0; // max index

        for (int i = 1; i < turtles.size(); i++) {

            Turtle item = turtles.get(i);

            if (item.getCapacity() > turtles.get(maxIndex).getCapacity()) {
                maxIndex = i;
            }

        }

        return maxIndex;
    }
}
