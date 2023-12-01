import java.util.ArrayList;
import java.util.List;

/*
Grab test:

check class: FindDistinctPathInTreeExample.png in desktop grabTestFolder

 */

class FindDistinctPathInTree {

    public int solution(Tree T) {

        List<Integer> visitedNodes = new ArrayList<>();
        int maxPath = findDistinctMaxPath(T, visitedNodes, Integer.MIN_VALUE);
        return maxPath;
    }

    private int findDistinctMaxPath(Tree T, List<Integer> visitedNodes, int tempMaxPath) {

        if (T == null || visitedNodes.contains(T.data)) {
            return visitedNodes.size();
        }

        visitedNodes.add(T.data);
        int maxPathAtRightTree = findDistinctMaxPath(T.rightNode, visitedNodes, tempMaxPath);
        int maxPathAtLeftTree = findDistinctMaxPath(T.leftNode, visitedNodes, tempMaxPath);

        if (maxPathAtRightTree > tempMaxPath) {
            tempMaxPath = maxPathAtRightTree;
        }

        if (maxPathAtLeftTree > tempMaxPath) {
            tempMaxPath = maxPathAtLeftTree;

        }

        visitedNodes.remove(new Integer(T.data));
        return tempMaxPath;

    }
}

