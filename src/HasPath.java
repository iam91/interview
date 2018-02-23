public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        return false;
    }

    public static void main(String[] args) {
        HasPath c = new HasPath();

        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {};
        System.out.println(c.hasPath(matrix, 3, 4, str));
    }
}
