package cn.yang.chineseChess;

public class ChessesEmun {

    public ChessesEmun chessesEmun;
    private static Location location;

    private final static String CHESS_NAME_CHE="车";
    private final static String CHESS_NAME_MA="马";
    private final static String CHESS_NAME_XIANG0="象";
    private final static String CHESS_NAME_SHI0="士";
    private final static String CHESS_NAME_SHI1="仕";
    private final static String CHESS_NAME_JIANG="将";
    private final static String CHESS_NAME_PAO="炮";
    private final static String CHESS_NAME_ZU="卒";
    private final static String CHESS_NAME_BING="兵";
    private final static String CHESS_NAME_XIANG1="相";
    private final static String CHESS_NAME_SHUAI="帅";


    private final static String CHESS_IMG_CHE0="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess4.png";
    private final static String CHESS_IMG_CHE1="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess11.png";

    private final static String CHESS_IMG_MA0="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess3.png";
    private final static String CHESS_IMG_MA1="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess10.png";

    private final static String CHESS_IMG_SHI0="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess1.png";
    private final static String CHESS_IMG_SHI1="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess8.png";

    private final static String CHESS_IMG_JIANG="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess0.png";
    private final static String CHESS_IMG_SHUAI="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess7.png";

    private final static String CHESS_IMG_PAO0="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess5.png";
    private final static String CHESS_IMG_PAO1="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess12.png";

    private final static String CHESS_IMG_ZU="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess6.png";
    private final static String CHESS_IMG_BING="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess13.png";

    private final static String CHESS_IMG_XIANG0="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess2.png";
    private final static String CHESS_IMG_XIANG1="/Users/world/IdeaProjects/chineseChess/src/imageSource/chess9.png";


    //开始布局
    public final static Chess[] regameLayout(Chess[] chesses, ChessBoard board){
        //黑子布局
        chesses[0] = new Chess(CHESS_NAME_CHE,(short)0,CHESS_IMG_CHE0);board.putChess(null,0,0,chesses[0]);
        chesses[1] = new Chess(CHESS_NAME_MA,(short)0,CHESS_IMG_MA0);board.putChess(null,1,0,chesses[1]);
        chesses[2] = new Chess(CHESS_NAME_XIANG0,(short)0,CHESS_IMG_XIANG0);board.putChess(null,2,0,chesses[2]);
        chesses[3] = new Chess(CHESS_NAME_SHI0,(short)0,CHESS_IMG_SHI0);board.putChess(null,3,0,chesses[3]);
        chesses[4] = new Chess(CHESS_NAME_JIANG,(short)0,CHESS_IMG_JIANG);board.putChess(null,4,0,chesses[4]);
        chesses[5] = new Chess(CHESS_NAME_SHI0,(short)0,CHESS_IMG_SHI0);board.putChess(null,5,0,chesses[5]);
        chesses[6] = new Chess(CHESS_NAME_XIANG0,(short)0,CHESS_IMG_XIANG0);board.putChess(null,6,0,chesses[6]);
        chesses[7] = new Chess(CHESS_NAME_MA,(short)0,CHESS_IMG_MA0);board.putChess(null,7,0,chesses[7]);
        chesses[8] = new Chess(CHESS_NAME_CHE,(short)0,CHESS_IMG_CHE0);board.putChess(null,8,0,chesses[8]);
        chesses[9] = new Chess(CHESS_NAME_PAO,(short)0,CHESS_IMG_PAO0);board.putChess(null,1,2,chesses[9]);
        chesses[10] = new Chess(CHESS_NAME_PAO,(short)0,CHESS_IMG_PAO0);board.putChess(null,7,2,chesses[10]);
        chesses[11] = new Chess(CHESS_NAME_ZU,(short)0,CHESS_IMG_ZU);board.putChess(null,0,3,chesses[11]);
        chesses[12] = new Chess(CHESS_NAME_ZU,(short)0,CHESS_IMG_ZU);board.putChess(null,2,3,chesses[12]);
        chesses[13] = new Chess(CHESS_NAME_ZU,(short)0,CHESS_IMG_ZU);board.putChess(null,4,3,chesses[13]);
        chesses[14] = new Chess(CHESS_NAME_ZU,(short)0,CHESS_IMG_ZU);board.putChess(null,6,3,chesses[14]);
        chesses[15] = new Chess(CHESS_NAME_ZU,(short)0,CHESS_IMG_ZU);board.putChess(null,8,3,chesses[15]);


        //红子布局
        chesses[16] = new Chess(CHESS_NAME_CHE,(short)1,CHESS_IMG_CHE1);board.putChess(null,0,9,chesses[16]);
        chesses[17] = new Chess(CHESS_NAME_MA,(short)1,CHESS_IMG_MA1);board.putChess(null,1,9,chesses[17]);
        chesses[18] = new Chess(CHESS_NAME_XIANG1,(short)1,CHESS_IMG_XIANG1);board.putChess(null,2,9,chesses[18]);
        chesses[19] = new Chess(CHESS_NAME_SHI1,(short)1,CHESS_IMG_SHI1);board.putChess(null,3,9,chesses[19]);
        chesses[20] = new Chess(CHESS_NAME_SHUAI,(short)1,CHESS_IMG_SHUAI);board.putChess(null,4,9,chesses[20]);
        chesses[21] = new Chess(CHESS_NAME_SHI1,(short)1,CHESS_IMG_SHI1);board.putChess(null,5,9,chesses[21]);
        chesses[22] = new Chess(CHESS_NAME_XIANG1,(short)1,CHESS_IMG_XIANG1);board.putChess(null,6,9,chesses[22]);
        chesses[23] = new Chess(CHESS_NAME_MA,(short)1,CHESS_IMG_MA1);board.putChess(null,7,9,chesses[23]);
        chesses[24] = new Chess(CHESS_NAME_CHE,(short)1,CHESS_IMG_CHE1);board.putChess(null,8,9,chesses[24]);
        chesses[25] = new Chess(CHESS_NAME_PAO,(short)1,CHESS_IMG_PAO1);board.putChess(null,1,7,chesses[25]);
        chesses[26] = new Chess(CHESS_NAME_PAO,(short)1,CHESS_IMG_PAO1);board.putChess(null,7,7,chesses[26]);
        chesses[27] = new Chess(CHESS_NAME_BING,(short)1,CHESS_IMG_BING);board.putChess(null,0,6,chesses[27]);
        chesses[28] = new Chess(CHESS_NAME_BING,(short)1,CHESS_IMG_BING);board.putChess(null,2,6,chesses[28]);
        chesses[29] = new Chess(CHESS_NAME_BING,(short)1,CHESS_IMG_BING);board.putChess(null,4,6,chesses[29]);
        chesses[30] = new Chess(CHESS_NAME_BING,(short)1,CHESS_IMG_BING);board.putChess(null,6,6,chesses[30]);
        chesses[31] = new Chess(CHESS_NAME_BING,(short)1,CHESS_IMG_BING);board.putChess(null,8,6,chesses[31]);



        return chesses;
    }


    //棋子的规范step
    public static boolean chessCanStep( Chess chess,int column,int row,ChessBoard chessBoard){
        String chessName = chess.name;
        location = new Location();
        location.setX(chess.x);
        location.setY(chess.y);
        location.changeToBoardLoc(chessBoard.getChessGrids());
        int chessCol = location.getColumn();
        int chessRow = location.getRow();
        int index= chessBoard.findChess(location);
        if(index==-1){
            throw new RuntimeException("未找到棋子");
        }
        int big,small;
        ChessGrid[][] chessGrids = chessBoard.getChessGrids();
        switch (chessName) {
            case "车":
                if (chessCol != column && chessRow != row) {
                    return false;
                }

                if (chessCol == column) {
                    big = Math.max(chessRow, row);
                    small = Math.min(chessRow, row);
                    for (int i = small + 1; i < big; i++) {
                        if (chessGrids[i][chessCol].haveChess) {
                            return false;
                        }
                    }
                }
                if (chessRow == row) {
                    big = Math.max(chessCol, column);
                    small = Math.min(chessCol, column);
                    for (int i = small + 1; i < big; i++) {
                        if (chessGrids[chessRow][i].haveChess) {
                            return false;
                        }
                    }
                }
                break;
            case "马":
                int xMove = Math.abs(chessCol - column);
                int yMove = Math.abs(chessRow - row);
                if (xMove * yMove != 2) {
                    return false;
                }
                if (xMove == 2) {
                    big = Math.max(chessCol, column);
                    if (chessGrids[chessRow][big - 1].haveChess) {
                        return false;
                    }

                } else if (yMove == 2) {
                    big = Math.max(chessRow, row);
                    if (chessGrids[big - 1][chessCol].haveChess) {
                        return false;
                    }
                }
                break;

            case "相":
                int xMove_xiang1 = Math.abs(chessCol - column);
                int yMove_xiang1 = Math.abs(chessRow - row);
                if (xMove_xiang1 != 2 || yMove_xiang1 != 2) {
                    return false;
                }
                if(row<5){
                    return false;
                }
                break;
            case "象":
                int xMove_xiang0 = Math.abs(chessCol - column);
                int yMove_xiang0 = Math.abs(chessRow - row);
                if (xMove_xiang0 != 2 || yMove_xiang0 != 2) {
                    return false;
                }
                if(row>4){
                    return false;
                }
                break;
            case "士":
                int xMove_shi0 = Math.abs(chessCol - column);
                int yMove_shi0 = Math.abs(chessRow - row);
                if (xMove_shi0 != 1 || yMove_shi0 != 1) {
                    return false;
                }
                if(!(column>=3&&column<=5&&row>=0&&row<=2)){
                    return false;
                }
                break;
            case "仕":
                int xMove_shi1 = Math.abs(chessCol - column);
                int yMove_shi1 = Math.abs(chessRow - row);
                if (xMove_shi1 != 1 || yMove_shi1 != 1) {
                    return false;
                }
                if(!(column>=3&&column<=5&&row>=7&&row<=9)){
                    return false;
                }
                break;
            case "将":
                int xMove_jiang = Math.abs(chessCol - column);
                int yMove_jiang = Math.abs(chessRow - row);
                if (xMove_jiang + yMove_jiang != 1) {
                    return false;
                }
                if(!(column>=3&&column<=5&&row>=0&&row<=2)){
                    return false;
                }
            break;
            case "帅":
                int xMove_shuai = Math.abs(chessCol - column);
                int yMove_shuai = Math.abs(chessRow - row);
                if (xMove_shuai + yMove_shuai != 1) {
                    return false;
                }
                if(!(column>=3&&column<=5&&row>=7&&row<=9)){
                    return false;
                }
                break;
            case "炮":
                if (chessCol != column && chessRow != row) {
                    return false;
                }
                //记录中间的棋子数
                int count =0;
                if(chessCol == column ){
                    big = Math.max(chessRow,row);
                    small=Math.min(chessRow,row);
                    for (int i = small + 1; i < big; i++) {
                        if (chessGrids[i][chessCol].haveChess) {
                            count++;
                        }
                    }
                }else if(chessRow == row){
                    big = Math.max(chessCol,column);
                    small=Math.min(chessCol,column);
                    for (int i = small + 1; i < big; i++) {
                        if (chessGrids[chessRow][i].haveChess) {
                            count++;
                        }
                    }
                }else {
                    return false;
                }
                if(!((count==0&&!chessGrids[row][column].haveChess)||(count==1&&chessGrids[row][column].haveChess))){
                    return false;
                }
                break;
            case "兵":
                int xMove_bing = Math.abs(chessCol - column);
                int yMove_bing = Math.abs(chessRow - row);
                if (xMove_bing + yMove_bing != 1) {
                    return false;
                }
                if(xMove_bing>0&&row>4){
                    return false;
                }
                break;
            case "卒":
                int xMove_zu = Math.abs(chessCol - column);
                int yMove_zu = Math.abs(chessRow - row);
                if (xMove_zu + yMove_zu != 1) {
                    return false;
                }
                if(xMove_zu>0&&row<5){
                    return false;
                }
                break;
        }


        return true;
    }






}
