package paula.game;


public class Player<I> extends FallingImage<I> {
  public Player(Vertex corner) {

    super("player.png", corner, new Vertex(0, 0));
  }
}
