import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
  public static void main(String [] args){
    Main game = new Main();
    game.setVisible(true);
  }

  public Main(){
    super("Морской бой");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int locationX = (screenSize.width - 300) / 2;
    int locationY = (screenSize.height - 200) / 2;
    this.setBounds(locationX, locationY,300,200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container container  = this.getContentPane();
    container.setLayout(new GridLayout(10,10));
    setFields(container);
  }
  private void setFields(Container container){
    int[][] dots = new int[10][10];
    dots = setDots(dots);
    for (int[] elem : dots){
      for (int dot : elem){
        System.out.print(dot);
      }
      System.out.println("");
    }
    ButtonShip [][] butArr = new ButtonShip[10][10];
    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        /*butArr[i][j]*/ButtonShip ship = new ButtonShip();
        ship.setShip(dots[i][j]);
        ship.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            System.out.println("fun");
            if (ship.getShip() == 1){
              ship.setText("x");
            } else {
              ship.setText(".");
            }
          }
        });
        butArr[i][j] = ship;
        container.add(butArr[i][j]);
      }
    }
  }
  private int[][] setDots(int[][] dots){
    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        dots[i][j] = (int)Math.round(Math.random());
      }
    }
    return dots;
  }

}
