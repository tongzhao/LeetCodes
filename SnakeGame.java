import java.util.LinkedList;

/**
 * 353. Design Snake Game
 *
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class SnakeGame {

    int rows;
    int cols;
    int len;
    int[][] food;
    LinkedList<Position> snake;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.rows = height;
        this.cols = width;
        this.food = food;

        snake = new LinkedList<Position>();
        snake.add(new Position(0,0));
        len = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Position curr = new Position(snake.get(0).x, snake.get(0).y);

        switch (direction.charAt(0)) {
            case 'U' : curr.x--; break;
            case 'L' : curr.y--; break;
            case 'R' : curr.y++; break;
            case 'D' : curr.x++; break;
        }
        if (curr.x < 0 || curr.x >= rows || curr.y < 0 || curr.y >= cols) return -1;

        for (int i = 1; i < snake.size()-1; i++) {
            Position next = snake.get(i);
            if (next.isEqual(curr)) return -1;
        }
        snake.addFirst(curr);
        if (len < food.length) {
            Position p = new Position(food[len][0], food[len][1]);
            if (curr.isEqual(p)) len++;
        }
        while (snake.size() > len+1) snake.removeLast();
        return len;
    }
    class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean isEqual(Position p) {
            return this.x==p.x && this.y==p.y;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
