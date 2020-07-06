package cn.yang.chineseChess;

import cn.yang.chineseChess.application.GameRunClient;

import java.awt.*;

public class ChessBoard{


    private ChessGrid[][] chessGrids;

    public Chess[] chesses = new Chess[32];

    public final static int ROWS = 10;
    public final static int COLUMNS = 9;

    public final static int BORDER_LEFT = 24;
    public final static int BORDER_TOP = 18;


    public ChessBoard(GameRunClient.CheckerBoard checkerBoard) {
        this.chessGrids = new ChessGrid[ROWS][COLUMNS];
        initBroad(checkerBoard);
    }


    public void initBroad(GameRunClient.CheckerBoard checkerBoard){
        for(int i=0;i<9;i++){
            for(int j=0;j<10;j++){
                chessGrids[j][i]=new ChessGrid(ChessGrid.GRID_WIDTH*i+BORDER_LEFT,
                        ChessGrid.GRID_HEIGHT*j+BORDER_TOP);
                if(chessGrids[j][i].haveChess){
                    checkerBoard.add(chessGrids[j][i].getChess());

                }

            }

        }
        System.out.println("==========================棋盘格子初始化/创建完成=======================");
    }



    public ChessGrid[][] getChessGrids() {
        return chessGrids;
    }


    public void restartBoard(){
        chesses = ChessesEmun.regameLayout(chesses,this);
        for(int i=0;i<chesses.length;i++){
            chesses[i].showBorder();

        }

    }


    public void putChess( ChessGrid old,int column,int row, Chess chess){
        if(old!=null){
            old.haveChess=false;
            old.setChess(null);
        }
        chess.x=chessGrids[row][column].x;
        chess.y=chessGrids[row][column].y;
        chessGrids[row][column].haveChess = true;
        chessGrids[row][column].setChess(chess);

    }

    public void eatChess(ChessGrid old, Chess eater,Chess eated){
        Location location = new Location();
        location.setX(eated.x);
        location.setY(eated.y);
        location.changeToBoardLoc(chessGrids);
        int index = findChess(location);

        if(index!=-1){
            putChess(old,location.getColumn(),location.getRow(),eater);
            chesses[index]=null;
        }

    }

    public int findChess(Location location){

        for (int i=0;i<chesses.length;i++){
            if(chesses[i]!=null&&chesses[i].x==chessGrids[location.getRow()][location.getColumn()].x&&chesses[i].y== chessGrids[location.getRow()][location.getColumn()].y){
                return i;
            }

        }
        return -1;

    }



    public void reflushBoard(Graphics g){

        for(int i=0;i<chesses.length;i++){
            if(null!=chesses[i]){
                chesses[i].paint(g);

            }
        }

    }

    //通过鼠标捕获到格子
    public ChessGrid catchChess(int x,int y){
        Location location = new Location();
        location.setX(x);
        location.setY(y);
        location.changeToBoardLoc(chessGrids);
        if(location!=null&&location.getRow()!=-1&&location.getColumn()!=-1){
            return chessGrids[location.getRow()][location.getColumn()];

        }
        return null;
    }

    public Chess[] getChesses() {
        return chesses;
    }

    public void setChesses(Chess[] chesses) {
        this.chesses = chesses;
    }


}
