package cn.yang.chineseChess;

import java.awt.*;

/**
 * 像素坐标与棋盘坐标互转
 *
 *
 */
public class Location {

    private int row;

    private int column;

    private int x;

    private int y;


    public void changeToBoardLoc(ChessGrid[][] chessGrids){
        int index_x=-1,index_y=-1;
        for(int i=0;i<chessGrids.length;i++){
            for(int j=0;j<chessGrids[i].length;j++){
                Rectangle r = new Rectangle(chessGrids[i][j].x, chessGrids[i][j].y, ChessGrid.GRID_WIDTH, ChessGrid.GRID_HEIGHT);
                if(r.contains(x,y)){
                    index_x = j;
                    index_y = i;
                    break;
                }
            }
        }
        this.row = index_y;
        this.column = index_x;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



}
