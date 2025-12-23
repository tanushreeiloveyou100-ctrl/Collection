package com.ibm.banking.basics;

import java.util.*;

public class Demo_collection {
    public static void main(String[] args) {

        // List example (ArrayList)
        List<String> employees = new ArrayList<>();
        employees.add("Alice");
        employees.add("Bob");
        employees.add("Charlie");
        System.out.println("List: " + employees);

        // Set example (HashSet)
        Set<String> skills = new HashSet<>();
        skills.add("Java");
        skills.add("Python");
        skills.add("Java"); // duplicate, won't be added
        System.out.println("Set: " + skills);

        // Map example (HashMap)
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");
        System.out.println("Map: " + employeeMap);

        // Queue example (LinkedList queue)
        Queue<String> taskQueue = new LinkedList<>();
        taskQueue.add("Build Project");
        taskQueue.add("Run Tests");
        taskQueue.add("Deploy");
        System.out.println("Queue Poll: " + taskQueue.poll());
        System.out.println("Queue Now: " + taskQueue);

        // Stack example using Deque
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Step 1");
        stack.push("Step 2");
        stack.push("Step 3");
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Now: " + stack);

        // PriorityQueue example
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        System.out.println("PriorityQueue Poll: " + numbers.poll());
        System.out.println("PriorityQueue Now: " + numbers);

        // LinkedHashMap example (preserves order)
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 88);
        System.out.println("LinkedHashMap: " + scores);

        // TreeSet example (sorted set)
        Set<Integer> sortedValues = new TreeSet<>();
        sortedValues.add(50);
        sortedValues.add(10);
        sortedValues.add(30);
        System.out.println("TreeSet: " + sortedValues);
    }
}

