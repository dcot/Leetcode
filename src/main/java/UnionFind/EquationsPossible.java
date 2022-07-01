package UnionFind;

public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        UnionFind un = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0)-'a';
                int b = equation.charAt(3)-'a';
                un.union(a,b);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0)-'a';
                int b = equation.charAt(3)-'a';
                if (un.isConnected(a,b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
