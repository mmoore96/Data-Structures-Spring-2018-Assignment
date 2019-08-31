
import java.util.List;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George Moore
 */

     class Subway extends Route
{
    
     private Map<String, LinkedHashSet<String>> map = new HashMap();
 
    public void addEdge(String station1, String station2)
    {
        LinkedHashSet<String> adjacent = map.get(station1);
        if (adjacent == null)
        {
            adjacent = new LinkedHashSet();
            map.put(station1, adjacent);
        }
        adjacent.add(station2);
    }
 
    public void addTwoWayVertex(String station1, String station2)
    {
        addEdge(station1, station2);
        addEdge(station2, station1);
    }
 
    public boolean isConnected(String station1, String station2)
    {
        Set adjacent = map.get(station1);
        if (adjacent == null)
        {
            return false;
        }
        return adjacent.contains(station2);
    }
 
    public LinkedList<String> adjacentStations(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedList();
        }
        return new LinkedList<String>(adjacent);
    }
 
    private static String  START;
    private static String  END;
    private static boolean flag;
    public static void main(String args[])
    {
        Subway graph = new Subway();
        
 
        graph.addEdge("140", "134");
        graph.addEdge("134", "Unicentro");
        graph.addEdge("Unicentro", "100");
        graph.addEdge("100", "30");
        graph.addEdge("30", "R");
        graph.addEdge("R", "Sabana");
        graph.addEdge("R", "Espec");
        graph.addEdge("Sabana", "19");
        graph.addEdge("19", "Germania");
        graph.addEdge("Germania", "Germania");
        graph.addEdge("Espec", "F");
        graph.addEdge("F", "F");
        graph.addEdge("R", "Marsella");
        graph.addEdge("Marsella", "Mu");
        graph.addEdge("Mu", "SENA");
        graph.addEdge("Mu", "Timiza");
        graph.addEdge("SENA", "Santiago");
        graph.addEdge("Santiago", "Gu");
        graph.addEdge("Gu", "Gu");
        graph.addEdge("Timiza", "Timiza");
        graph.addEdge("Mu", "Bosa");
        //graph.addEdge("Bosa", "Bosa");
        LinkedList<String> visited = new LinkedList();
        System.out.println("Enter the source Station:");
        Scanner sc = new Scanner(System.in);
        START = sc.next();
        System.out.println("Enter the destination Station:");
        END = sc.next();
 
        visited.add(START);
        new Subway().breadthFirst(graph, visited);
        sc.close();
    }
 
    private void breadthFirst(Subway graph,
            LinkedList<String> visited)
    {
        LinkedList<String> stations = graph.adjacentStations(visited.getLast());
 
        for (String station : stations)
        {
            if (visited.contains(station))
            {
                continue;
            }
            if (station.equals(END))
            {
                visited.add(station);
                printPath(visited);
                flag = true;
                visited.removeLast();
                break;
            }
        }
 
        for (String station : stations)
        {
            if (visited.contains(station) || station.equals(END))
            {
                continue;
            }
            visited.addLast(station);
            breadthFirst(graph, visited);
            visited.removeLast();
        }

    }
 
    private void printPath(LinkedList<String> visited)
    {
        if (flag == false)
            System.out.println("The route between Station " + START
                    + " and Station " + END + " is: ");
 
        for (String station : visited)
        {
            System.out.print(station);
            System.out.print(", ");
        }
        System.out.println();
    }
}