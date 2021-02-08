package paula.game;

public class Dream<I> extends AbstractGameObject<I> {


  public Dream(double height, double width, Vertex position, Vertex velocity) {
    super(width, height, position, velocity);

  }

  @Override
  public void paintTo(GraphicsTool<I> g) {
    g.setColor(0.3, 0.3, 0.3);
    g.drawOval(position.x,position.y, width, height);
    g.setColor(0.8, 0.8, 1);
    g.fillOval(position.x,position.y, width, height);

  }
}