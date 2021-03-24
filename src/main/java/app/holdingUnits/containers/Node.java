package app.holdingUnits.containers;

import app.search.Value;

import java.util.HashMap;

/**
 * Node is holding name of the unit and all its rules converting (edges). Also class Node holding all units (Nodes)
 * which have been preloaded.
 *
 * @version 1.0.0 10 Mar 2021
 * @author Aleksey Lkahanskii
 *
 */
public class Node {

    /** contains all added nodes. */
    public static HashMap<String, Node> nodesForNames = new HashMap<>();

    /** contains graph for existing nodes. */
    public static HashMap<String, Graph> graphsForNames = new HashMap<>();

    /** name of the node. */
    public String name;

    /** converting rule to the first unit in the graph */
    public Value convertingRule;

    /**
     * creates new node if node with the same name does not exist yet.
     * @param name name of the new node which need to create.
     * @return new node or null if node already exists.
     */
    public static Node createNode(String name) {
        if (checkExistence(name)) {
            return null;
        }
        Node newNode = new Node(name);
        nodesForNames.put(name, newNode);
        return newNode;
    }

    /**
     * checks existence of the node with the same name.
     * @param name name of the node which existence need be checked.
     * @return true if node exists else return false.
     */
    public static boolean checkExistence (String name) {
        return nodesForNames.get(name) != null;
    }

    /**
     * constructs node.
     * @param nodeName name of new node.
     */
    private Node(String nodeName) {
        name = nodeName;
        convertingRule = new Value("1");
    }

    /**
     * gets converting rule from this node to the first node of the graph in which it's exists.
     * @return the converting rule.
     */
    public Value getConvertingRule() {
        return convertingRule;
    }

    /**
     * sets new converting rule.
     * @param convertingRule new rule.
     */
    public void setConvertingRule(Value convertingRule) {
        this.convertingRule = convertingRule;
    }

    /**
     * sets graph for node.
     * @param name name of the node for which graph sets.
     * @param graph graph to set.
     */
    public static void setGraphsForName(String name, Graph graph) {
        graphsForNames.put(name, graph);
    }

    /**
     * gets graph.
     * @param name node name.
     * @return graph.
     */
    public static Graph getGraph(String name) {
        return graphsForNames.get(name);
    }

    /**
     * gets name.
     * @return name.
     */
    public String getName() {
        return name;
    }
}
