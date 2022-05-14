package UI;

import Game.LifeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

/**
 * @author Qiezbgao
 * @Description
 * @create 2022-05-11 15:11
 */
public class GameComponent extends JComponent {
    private LifeGame lifeGame;
    public ImageIcon image = new ImageIcon("src//UI//hd10.png");

    /**
     * @Description 在容器中开启计时器
     * @param lifeGame 需要通过 LifeGame 拿到 map 的数据
     * @param t 游戏刷新时间（ms）
     */
    public GameComponent(LifeGame lifeGame,int t) {
        this.lifeGame = lifeGame;
        Timer time = new Timer(t, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lifeGame.game_cycle();
                repaint();
            }
        });
        time.start();
    }

    /**
     * @Descriptio 返回上层容器大小
     * @return
     */
    public Dimension getPreferredSize(){
        return new Dimension(lifeGame.getGameMap().getMaxY()*10,lifeGame.getGameMap().getMaxX()*10);
    }

    /**
     * @Description 绘制一次图像
     * @param g
     */
    public void paintComponent(Graphics g){
        //image.paintIcon(this,g,10,10);

        int x=lifeGame.getGameMap().getMaxX();
        int y=lifeGame.getGameMap().getMaxY();
        int[][] map = lifeGame.getGameMap().getMap();

        // 画网格
        Graphics2D g2 = (Graphics2D) g;
        int index=1;
        Line2D l1 = new Line2D.Double(0,0,0,0);
        for(int i=0;i<=x;i++){
            l1.setLine(0,index,y*10,index);
            g2.draw(l1);
            index+=10;
        }
        index=1;
        Line2D l2 = new Line2D.Double(0,0,0,0);
        for(int i=0;i<=y;i++){
            l2.setLine(index,0,index,x*10);
            g2.draw(l2);
            index+=10;
        }

        // 画黑点
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(map[i][j] == 1) image.paintIcon(this,g,10*j,10*i);
            }
        }

        setVisible(true);
    }
}
