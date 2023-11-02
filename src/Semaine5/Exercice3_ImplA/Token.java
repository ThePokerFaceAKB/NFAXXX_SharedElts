package Semaine5.Exercice3_ImplA;

public class Token {


    private TokenVisibleColor color;
    boolean isOnGameBoard;
    private int xAdress;
    private int yAdress;

    public Token(TokenVisibleColor color, int xAdress, int yHumanAdress) {
        this.color = color;
        this.xAdress = xAdress;
        this.yAdress = yHumanAdress - 1;
        this.isOnGameBoard = false;
    }

    public Token(TokenVisibleColor color, char xLetterAdress, int yHumanAdress) {
        this.color = color;
        this.xAdress = GameBoard.getXIndexFromLetter(xLetterAdress);
        this.yAdress = yHumanAdress - 1;
        this.isOnGameBoard = false;
    }

    public void setIsOnGameBoard() {
        this.isOnGameBoard = true;
    }
    public void setColor(TokenVisibleColor newColor){
        this.color=newColor;
    }

    public TokenVisibleColor getColor() {
        return this.color;
    }

    public String toString() {
        String tokenDisplay;
        //tokenDisplay= this.color+" Token at ["+this.xAdress.toString()+";"+this.yAdress.getValue()+"]";
        tokenDisplay = this.color + " Token at [" + GameBoard.getXLetterFromIndex(this.xAdress) + (this.yAdress + 1) + "]";
        return tokenDisplay;

    }


}




