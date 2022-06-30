package DFSAndStack;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
//超时一般考虑visited
    public Node cloneGraph(Node node) {
        return dfs(node,new HashMap<>());
    }
    public Node dfs(Node node,HashMap<Integer, Node> visited) {
        if (node == null) return null;
        if (visited.containsKey(node.val)) return visited.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(newNode.val, newNode);
        for (Node cur : node.neighbors) {
            newNode.neighbors.add(dfs(cur,visited));
        }
        return newNode;
    }
}
