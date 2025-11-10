import java.util.Arrays;

public class assignment5 {
    private int helper(String tiles, boolean[] visited) {
        int count = 0;
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i] || (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1) && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            count++; // Count the current tile
            count += helper(tiles, visited); // Recurse for the remaining tiles
            visited[i] = false; // Backtrack
        }
        return count;
    }

    public int numTilePossibilities(String tiles) {
        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        boolean[] visited = new boolean[charArray.length];
        return helper(new String(charArray), visited);
    }
}
