package paula.game;

public class NoWalkThroughs<I> extends AbstractGameObject<I> {


  public NoWalkThroughs(double height, double width, Vertex position, Vertex velocity) {
    super(width, height, position, velocity);

  }

  @Override
  public void paintTo(GraphicsTool<I> g) {

    g.setColor(0.1,0.1,0.1);
    g.fillRect(position.x,position.y,width, height);

  }
}