package cn.yang.chineseChess;


public class ChessGrid{

    public final static int GRID_WIDTH = 62;
    public final static int GRID_HEIGHT = 56;
    public int x;
    public int y;
    private Chess chess;


    public boolean haveChess;


    public ChessGrid(int x, int y) {

        this.x = x;
        this.y = y;
        this.haveChess = false;
    }


    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

}
