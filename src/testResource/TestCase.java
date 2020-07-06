package testResource;

import cn.yang.chineseChess.Chess;
import cn.yang.chineseChess.application.GameRunClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestCase {


    public static void main(String[] args) {
        JFrame f = new JFrame() ;
        f.setSize(GameRunClient.WINDOW_WIDTH, GameRunClient.WINDOW_HEIGHT);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setTitle("中国象棋");
        f.setLocationRelativeTo(null);

        Chess chess = new Chess("212",(short)0,"34243");
        chess.setSize(Chess.CHESS_WIDTH+80,Chess.CHESS_HEIGHT+80);
        chess.setLocation(150,150);
//        chess.showBorder();
        chess.setBorder(BorderFactory.createLineBorder(Color.red,30));
        chess.setBackground(Color.GREEN);
        f.add(chess);
        f.setVisible(true);


        chess.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                chess.setBorder(BorderFactory.createLineBorder(Color.green,30));


            }
        });



    }



}
