package paula.game;
//spielfeld bewegen

import java.util.ArrayList;
import java.util.List;

public class Moonlight<I, S> extends AbstractGame<I, S> {
  List<GameObject<I>> hintergrund = new ArrayList<>();
  List<Nightmare<I>> nightmare = new ArrayList<>();
  List<Dream<I>> dream = new ArrayList<>();
  List<NoWalkThroughs<I>> noWalkThroughs = new ArrayList<>();
  Player<I> player;


  int hit = 0;

  public Moonlight() {
    super(new Player<>(new Vertex(0, 0)), 1000, 900);

    //TODO double height, double width, Vertex position, Vertex velocity
    player = (Player<I>) getPlayer();
    Nightmare nm1 = new Nightmare(25, 25, new Vertex(1, 1), new Vertex(20, 20));
    Dream dr = new Dream(25, 25, new Vertex(700, 700), new Vertex(0, 0));
    NoWalkThroughs floor = new NoWalkThroughs(20, width, new Vertex(0, 880), new Vertex(0, 0));

    hintergrund.add(new ImageObject<>("Woodss.jpg"));
    getGOss().add(hintergrund);

    nightmare.add(nm1);
    getGOss().add(nightmare);

    dream.add(dr);
    getGOss().add(dream);

    noWalkThroughs.add(floor);
    getGOss().add(noWalkThroughs);

    getButtons().add(new Button("Pause", () -> pause()));
    getButtons().add(new Button("Start", () -> start()));
    getButtons().add(new Button("Exit", () -> System.exit(0)));
  }

  public void huntPlayer() {
    for (int i = 0; i < nightmare.size(); i++) {
      nightmare.get(i).hunt(getPlayer().getPos());
    }
  }

  public void standing() {
    boolean onTop = false;
    for (NoWalkThroughs<I> floor : noWalkThroughs) {
      if (player.touches(floor)) {
        player.stop();
        return;
      }
      if (player.isStandingOnTopOf(floor)) {
        onTop = true;
      }
    }
  }
  int dreamCount;
  public void collect(){
    Dream<I> delete = null;
    for(Dream<I> dream : dream){
      if(getPlayer().touches(dream)){
        delete = dream;
        dreamCount++;
        break;
      }
    }
    if (delete!=null){
      dream.remove(delete);
    }
  }

  @Override
  public void doChecks() {

    huntPlayer();
    standing();
    collect();



  }

  @Override
  public boolean isStopped() {
    return super.isStopped() || hit >= 3;
  }

  @Override
  public void keyPressedReaction(KeyCode keycode) {

    if (keycode != null)
      switch (keycode) {
        case RIGHT_ARROW:
          getPlayer().setVelocity(new Vertex(2, 0));
          break;
        case LEFT_ARROW:
          getPlayer().setVelocity(new Vertex(-2, 0));
          break;
        case DOWN_ARROW:
          getPlayer().setVelocity(new Vertex(0, 5));
          player.isJumping = false;
          break;
        case UP_ARROW:
          getPlayer().setVelocity(new Vertex(0, -5));
          player.jump();
          player.isJumping = true;
          break;
        default:
          ;
      }
  }

  @Override
  public void keyReleasedReaction(KeyCode keycode) {
    getPlayer().setVelocity(new Vertex(0, 0));

  }
}
