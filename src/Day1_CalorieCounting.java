import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day1_CalorieCounting {
    public static Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
    public static List<Integer> caloriesPerElf = new ArrayList<Integer>();

    /*
     * Updates global mapping with the map of <Integer elfNum, Integer calories>
     */
    public void createMappingAndList(String inputData) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputData));
        String line = sc.nextLine();
        int calories;
        int sum = 0;
        int elfNum = 1;
        while (sc.hasNextLine()) {
            // if the line is empty, add sum to the mapping for each customer and reset sum
            if (line.equals("")) {
                sum = 0;
                elfNum++;
            } else {
                calories = Integer.parseInt(line);
                sum += calories;
            }
            mapping.put(elfNum, sum);
            caloriesPerElf.add(sum);
            // System.out.println(line);
            line = sc.nextLine();
        }
        sc.close();
    }

    /* based on input integer of calories */
    public int getElfNum(int calories) {
        int elfNum = 0;
        for (java.util.Map.Entry<Integer, Integer> entry : mapping.entrySet()) {

            // if give value is equal to value from entry
            // print the corresponding key
            if (entry.getValue() == calories) {
                elfNum = entry.getKey();
            }
        }
        return elfNum;
    }

    public void sortElves() {
        Collections.sort(caloriesPerElf);
    }

    public void getTopThree() throws FileNotFoundException {
        createMappingAndList("AdventOfCode/data/day1input.txt");
        sortElves();
        System.out.println("The top three calories are: " + caloriesPerElf.get(caloriesPerElf.size() - 1)
                + ", " + caloriesPerElf.get(caloriesPerElf.size() - 2) + ", "
                + caloriesPerElf.get(caloriesPerElf.size() - 3));
        int sum = caloriesPerElf.get(caloriesPerElf.size() - 1) + caloriesPerElf.get(caloriesPerElf.size() - 2)
                + caloriesPerElf.get(caloriesPerElf.size() - 3);
        System.out.println("The sum of the top three calories is: " + sum);
    }

    public int findMaxCalories(Map<Integer, Integer> map) {
        // loop through map and find the max
        int calories;
        int elfNum = 1;
        int maxCalories = map.get(1);
        while (elfNum < map.size() - 1) {
            calories = map.get(elfNum + 1);
            if (calories > maxCalories) {
                maxCalories = calories;
            }
            elfNum++;
        }
        return maxCalories;

    }

    public static void main(String[] args) throws Exception {
        Day1_CalorieCounting obj = new Day1_CalorieCounting();
        obj.getTopThree();
    }
}