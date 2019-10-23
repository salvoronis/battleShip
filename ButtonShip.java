import javax.swing.*;

public class ButtonShip extends JButton {
  private int ship;
  public void setShip(int ship){
    this.ship = ship;
  }
  public int getShip(){
    return this.ship;
  }
}
