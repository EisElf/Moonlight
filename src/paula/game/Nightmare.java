package paula.game;


public class Nightmare<I> extends AbstractGameObject<I> {

  public Nightmare(double height, double width, Vertex position, Vertex velocity) {
    super(width, height, position, velocity);
  }

  @Override
  public void paintTo(GraphicsTool<I> g) {
    g.setColor(0.3, 0.3, 0.3);
    g.drawOval(this.getPos().x, this.getPos().y, width, height);
    g.setColor(0, 0, 0);
    g.fillOval(this.getPos().x, this.getPos().y, width, height);

  }

  public void hunt(Vertex playerPosition) {
    Vertex vector = new Vertex(playerPosition.x - this.getPos().x, playerPosition.y - this.getPos().y);
    double vectorLength = Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2));
    Vertex scale = new Vertex(vector.x / vectorLength, vector.y / vectorLength);
    double speed=1;
    this.setVelocity(new Vertex(scale.x * speed, scale.y * speed));

  }

}