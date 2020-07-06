package cn.yang.chineseChess.application;


import cn.yang.chineseChess.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.rmi.activation.ActivationMonitor;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameRunClient extends JFrame{

    //窗口大小
    public static final int WINDOW_WIDTH=700;
    public static final int WINDOW_HEIGHT=880;

    //棋盘大小
    public final static int BOARD_WIDTH=600;
    public final static int BOARD_HEIGHT=600;

    private static  CheckerBoard board;

    private ChessBoard chessboard;

    private short currentPlayer =1;
    private JLabel gameMessage;
    private JLabel gameNotice;

    private static String message="红色方执棋";

    public GameRunClient() {
        board= new CheckerBoard();
        this.setVisible(false);
        gameMessage = new JLabel();
        gameMessage.setSize(120,40);
        gameMessage.setLocation(50,50);
        gameMessage.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
        gameMessage.setHorizontalAlignment(0);
        gameMessage.setForeground(Color.RED);

        gameNotice = new JLabel();
        gameNotice.setSize(200,55);
        gameNotice.setLocation(280,70);
        gameNotice.setHorizontalAlignment(0);
        gameNotice.setForeground(Color.magenta);
        gameNotice.setOpaque(true);
        gameNotice.setBackground(Color.lightGray);
        Font font = new Font("宋体",Font.PLAIN,22);
        gameNotice.setFont(font);
        gameNotice.setVisible(false);

        this.add(board);
        this.add(gameMessage);
        this.add(gameNotice);

        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("中国象棋");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        scheduledExecutorService = Executors.newScheduledThreadPool(2);


        sendMessage(currentPlayer==0?"黑色方执棋":"红色方执棋",currentPlayer==0?Color.BLACK:Color.RED,gameMessage);


    }


    //建棋盘和初始布局
    public class CheckerBoard extends JPanel{
        Chess firstChess;
        Chess selectedChess;
        Location location;
        ChessGrid old;
        ChessGrid[][] chessGrids;

        public CheckerBoard(){
            super.setLocation(50,150);//面板的位置
            super.setSize(BOARD_WIDTH,BOARD_HEIGHT);//面板的宽,高
            chessboard = new ChessBoard(this);
            chessboard.restartBoard();
            chessGrids=chessboard.getChessGrids();
            location = new Location();
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point point = e.getPoint();

                    ChessGrid selectedChessGrid= chessboard.catchChess(point.x,point.y);
                    //如果chessGrid为空，说明没有点在棋盘上，直接跳出方法
                    if(selectedChessGrid==null){
                        return;
                    }
                    selectedChess = selectedChessGrid.getChess();
                    //当第一个棋子未被确定时，点击空格和对方的棋子是没用的


                    //第一个棋子还未被选
                    if(null==firstChess&&selectedChess!=null){
                        //选中的是己方棋子
                        if(selectedChess.player==currentPlayer){
                            firstChess = selectedChess;
                            System.out.println("选中第一个棋子，Chess:"+firstChess.toString());
                            return;
                        }else {
                        //选中的是对方的棋子
                            return;
                        }

                    //第一个棋子已被选中
                    }else if(null!=firstChess){
                        location.setX(firstChess.x);
                        location.setY(firstChess.y);
                        location.changeToBoardLoc(chessGrids);

                        old = chessboard.getChessGrids()[location.getRow()][location.getColumn()];
                        //选中的格子无棋子
                        location.setX(selectedChessGrid.x);
                        location.setY(selectedChessGrid.y);
                        location.changeToBoardLoc(chessGrids);
                        if(selectedChess==null){
                            if(ChessesEmun.chessCanStep(firstChess,location.getColumn(),location.getRow(),chessboard)){
                                chessboard.putChess(old,location.getColumn(),location.getRow(),old.getChess());
                                System.out.println("移动的子：   "+old.toString()+"移动至：   坐标X:"+location.getColumn()+" , Y:"+location.getRow() );
                                firstChess = null;
                                selectedChess =null;
                                changePlayer();
                            }else{
                                showNotice(firstChess.name+ ",不可走!");
                            }

                        //选中的格子有棋子
                        }else{
                            //选中的是对方棋子
                            if(selectedChess.player!=currentPlayer){
                                if(ChessesEmun.chessCanStep(firstChess,location.getColumn(),location.getRow(),chessboard)){
                                    //吃子
                                    chessboard.eatChess(old,firstChess,selectedChess);
                                    System.out.println("吃子:"+firstChess.toString()+"=======吃>>>>>>"+selectedChess.toString());
                                    firstChess = null;
                                    selectedChess =null;
                                    changePlayer();
                                }else{
                                    showNotice(firstChess.name+ ",不可走!");

                                }
                            }else {
                                //选中的是己方的棋子
                                firstChess = selectedChess;
                                System.out.println("选中第一个棋子，Chess:"+firstChess.toString());

                            }
                        }
                    }else{
                        //firstChess为空，点击到空格区
                        return;

                    }
                    repaint();
                }
            });


            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Chess[] chesses = chessboard.getChesses();
                    if(chesses[4]==null||chesses[20]==null){
                        message = (chesses[4]==null?"红方胜":"黑方胜")+" 游戏结束！";
                        sendMessage(message,chesses[4]==null?Color.RED:Color.BLACK,gameMessage);
                        gameOver();
                    }
                }
            });
        }


        public void paint(Graphics g){
            g.clearRect(0, 0, this.getWidth(), this.getHeight());
            Image backgroundImage = Toolkit.getDefaultToolkit().getImage("/Users/world/IdeaProjects/chineseChess/src/imageSource/chessBoard.png");
            g.drawImage(backgroundImage,0,0,600,600,this);
            chessboard.reflushBoard(g);
        }

    }

    public void sendMessage(String message,Color color,JLabel jl){
        jl.setText(message);
        if(color!=null)gameMessage.setForeground(color);

    }

    private ScheduledExecutorService scheduledExecutorService;
    public void showNotice(String message){
        sendMessage(message,null,gameNotice);
        gameNotice.setVisible(true);

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                gameNotice.setVisible(false);
            }
        }, 2, TimeUnit.SECONDS);

    }

    public void changePlayer(){
        currentPlayer=(short)((currentPlayer+1)%2);
        sendMessage(currentPlayer==0?"黑色方执棋":"红色方执棋",currentPlayer==0?Color.BLACK:Color.RED,gameMessage);
    }

    public void gameOver(){
        for (MouseListener l: board.getMouseListeners()
             ) {
            board.removeMouseListener(l);

        }

    }

    public static void main(String[] args) {
        new GameRunClient();
    }




}
