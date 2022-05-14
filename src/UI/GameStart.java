package UI;

import Game.LifeGame;

import javax.swing.*;

/**
 * @author Qiezbgao
 * @Description
 * @create 2022-05-11 15:07
 */
public class GameStart extends JFrame {
    private LifeGame lifeGame;

    /**
     * @Description UI 框体
     * @param lifeGame,需要构造  LifeGam 的参数，地图大小，黑点出现的比例
     */
    public GameStart(LifeGame lifeGame,int time){
        this.lifeGame = lifeGame;
        add(new GameComponent(lifeGame,time));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    /**
     * @Description Test
     * @param args
     */
    public static void main(String[] args) {
        GameStart gameStart = new GameStart(new LifeGame(80,80,0.4),500);
    }
}
