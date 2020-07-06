package cn.yang.chineseChess;

import javax.swing.*;
import java.awt.*;

public class Chess extends JComponent {

    public final static int CHESS_WIDTH = 58;
    public final static int CHESS_HEIGHT = 58;

    public int x;
    public int y;
    public Image chessImg;
    public String name;
    private Toolkit kit= Toolkit.getDefaultToolkit();
    // 红是1，黑是0
    public short player;
    public boolean isSelected=true;


    public Chess(String name,short player,String imgUrl) {
        this.name = name;
        this.player = player;
        this.chessImg =kit.getImage(imgUrl);
        this.setSize(CHESS_WIDTH,CHESS_HEIGHT);
    }

    public void showBorder(){
        if (isSelected){
            this.setBorder(BorderFactory.createLineBorder(Color.RED,30));

        }

    }

    public void paint(Graphics g){
        g.drawImage(chessImg,x,y,CHESS_WIDTH,CHESS_HEIGHT,null);
    }

    @Override
    public String toString() {

        return "chess的name:【"+this.name+"】, x坐标："+this.x+", y坐标："+this.y+", "+(player==(short)0?"黑色方":"红色方");
    }
}
