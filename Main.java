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
    //4 СРАННЫХ КОРАБЛЯ
    dots = setSHIP(dots, 1, 6, 3, 4);
    //3 СТРАННЫХ КОРАБЛЯ
    dots = setSHIP(dots, 2, 7, 2, 3);
    //2 СТРАННЫХ КОРАБЛЯ
    dots = setSHIP(dots, 3, 7, 1, 2);
    //1 СТРАННЫХ КОРАБЛЯ
    dots = setSHIP(dots, 4, 7, 0, 1);




    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        //dots[i][j] = (int)Math.round(Math.random());
        if (dots[i][j] != 1){
          dots[i][j] = 0;
        }
      }
    }
    return dots;
  }

  private int[][] setSHIP (int[][] dots, int koll, int krisa, int num, int rasm){
    for(int kol = 0; kol < koll; kol++){
      int x = (int)Math.round(Math.random()*9);
      int y = (int)Math.round(Math.random()*9);
      System.out.printf("x: %d , y: %d \n",x,y);

      int getLucky = (int)Math.round(Math.random());

      if (getLucky == 1){
        if (y > krisa){
          y = 0;
          //если корабль находится в жепе y
        }else{
          //если находится в начале y
          if ((dots[x][y] == 1) || (dots[x][y+1] == 1) || (dots[x][y+2] == 1)){
            if (y == 9){y = 0;}
            y++;
            if (y == 9){y = 0;}
            System.out.println("yabai");
          }
        }


        if (y > krisa) {
          int ostatok = 9 - y;
          int ostatokcopy = 9 - y;
          for (; ostatok>0; ostatok--){
            dots[x][y+ostatok] = 1;
          }
          int invost = num - ostatokcopy;
          for (; invost>=0; invost--){
            dots[x][y-invost] = 1;
          }
        }else{
          for (int i = 0; i<rasm; i++){
            dots[x][y+i] = 1;
          }
        }
      } else {
        if (x > krisa){
          x = 0;
          //если корабль находится в жепе x
        }else{
          //если находится в начале x
          if ((dots[x][y] == 1) || (dots[x+1][y] == 1) || (dots[x+2][y] == 1)){
            if (x == 9){x = 0;}
            y++;
            if (x == 9){x = 0;}
            System.out.println("yabai");
          }
        }


        if (x > krisa) {
          int ostatok = 9 - x;
          int ostatokcopy = 9 - x;
          for (; ostatok>0; ostatok--){
            dots[x+ostatok][y] = 1;
          }
          int invost = 2 - ostatokcopy;
          for (; invost>=0; invost--){
            dots[x-invost][y] = 1;
          }
        }else{
          for (int i = 0; i<rasm; i++){
            dots[x+i][y] = 1;
          }
        }
      }
    }
    return dots;
  }

}
