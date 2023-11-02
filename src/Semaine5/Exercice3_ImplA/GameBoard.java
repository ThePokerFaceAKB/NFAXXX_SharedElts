package Semaine5.Exercice3_ImplA;

public class GameBoard {
    final public static char[] xIndexLetterMapArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public static char getXLetterFromIndex(int arrayIndex) {
        if (arrayIndex < 0 || arrayIndex > xIndexLetterMapArray.length) {
            throw new IllegalArgumentException("you can't search the matching char with an index OutOfBound of the mapping array");
        }
        return xIndexLetterMapArray[arrayIndex];
    }

    public static int getXIndexFromLetter(char arrayLetterIndex) {
        for (int i = 0; i < xIndexLetterMapArray.length; i++) {
            if (xIndexLetterMapArray[i] == arrayLetterIndex) {
                return i;
            }
        }
        throw new IllegalArgumentException("the letter searched doesn't belong to the mapping array");
    }

    //private Case[][] caseMatrix=new Case[8][8];
    private Token[][] caseMatrix;

    public GameBoard() { // init of the 64 matrix Case Board
        caseMatrix = new Token[8][8];
        this.setGameBoard();
    }

    public boolean putNewTokenOnBoard(TokenVisibleColor color, char LetterXAdress, int humanYAdress) { // ajouter le controle de la presence d'un token
        Token tokenToPut = new Token(color, LetterXAdress, humanYAdress);
        int caseX = getXIndexFromLetter(LetterXAdress);
        int caseY = humanYAdress - 1;
        caseMatrix[caseX][caseY] = tokenToPut;
        tokenToPut.setIsOnGameBoard();
        return true;
    }

    public void reverseTokenOnBoard(char LetterXAdress, int humanYAdress) {
        int caseX = getXIndexFromLetter(LetterXAdress);
        int caseY = humanYAdress - 1;
        TokenVisibleColor actualColor;
        //Token tokenToPut = new Token(color, LetterXAdress, humanYAdress);
        Token tokenOnBoard = caseMatrix[caseX][caseY];
        actualColor = tokenOnBoard.getColor();
        switch (actualColor) {
            case WHITE:
                tokenOnBoard.setColor(TokenVisibleColor.BLACK);
                break;
            case BLACK:
                tokenOnBoard.setColor(TokenVisibleColor.WHITE);
                break;
            default:
                throw new IllegalStateException("The token must be either with black or White visible color");
        }
    }

    public void setGameBoard() { // put the four initals tokens on the board
        putNewTokenOnBoard(TokenVisibleColor.BLACK, 'e', 4);
        putNewTokenOnBoard(TokenVisibleColor.BLACK, 'd', 5);
        putNewTokenOnBoard(TokenVisibleColor.WHITE, 'd', 4);
        putNewTokenOnBoard(TokenVisibleColor.WHITE, 'e', 5);
    }

    public String toString() {
        String displayMsg;
        displayMsg = "   a  b  c  d  e  f  g  h";
        for (int j = 0; j < caseMatrix.length; j++) {
            displayMsg += "\n";
            displayMsg += (j + 1) + " ";
            for (int i = 0; i < caseMatrix.length; i++) {
                displayMsg += getCaseContent(i, j);
            }
        }
        displayMsg += "\n";
        return displayMsg;
    }

    public String getCaseContent(int x, int y) {
        String contentValue;
        //char tokenSymbol;
        if (caseMatrix[x][y] == null) {
            contentValue = "[ ]";
            return contentValue;
        }
        if (caseMatrix[x][y].getColor() == TokenVisibleColor.BLACK) {
            contentValue = "[B]";
            return contentValue;
        }
        if (caseMatrix[x][y].getColor() == TokenVisibleColor.WHITE) {
            contentValue = "[W]";
            return contentValue;
        }
        contentValue = "[ ]";
        return contentValue;
    }

    public void displayGameBoard() {
        System.out.print("   a  b  c  d  e  f  g  h");
        for (int j = 0; j < caseMatrix.length; j++) {
            System.out.println();
            System.out.print(j + 1 + " ");
            for (int i = 0; i < caseMatrix.length; i++) {
                System.out.print(getCaseContent(i, j));
            }
        }
        System.out.println();
    }

}



