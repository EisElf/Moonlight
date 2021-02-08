package paula.game;

public interface SoundTool<S> {
  S loadSound(String fileName);
  void playSound(S sound);
}
