package Semaine5.Exercice3_ImplA;
/**
 *1ere esquisse
 * on s'appuie sur le fait que le contenu d'une case tableau ne referencera aucun Token (null) pour identifier une case vide.
 *(Reste à faire :
 * --renommage plus pertinent  de certains parametres et attributs
 * --ajout de la gestion des exception dans les différentes méthodes
 * --deplacer certaines methodes , tache  dans la classe Token plutot que GameBoard.
 * --l'attribut isOnGameBoard est inutile ..
 * --en cosmétique : travailler éventuellement sur le print du plateau de jeu avec des  Char unicode () pour des symboles cercle plein , cercle vide.
 *)
 */

public class GameManage {

    public static void main(String[] args){
//        Token jetonA=new Token(TokenVisibleColor.WHITE,'e',4);
//        System.out.println(jetonA);
        GameBoard newParty =new GameBoard();
//        newParty.setGameBoard();
        System.out.println(newParty);
        newParty.putNewTokenOnBoard(TokenVisibleColor.BLACK,'f',5);
        newParty.reverseTokenOnBoard('e',5);
        System.out.println(newParty);
    }
}
