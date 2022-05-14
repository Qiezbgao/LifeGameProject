package Game;

import static java.lang.Thread.sleep;

/**
 * @author Qiezbg
 * @Description
 * @create 2022-05-06 15:38
 */
public class GameTimer {
    private LifeGame lifeGame;

    public GameTimer(LifeGame lifeGame) {
        this.lifeGame = lifeGame;
    }

    /**
     * @Description 不展示对外的实际控制方法
     * @param time 每次刷新的间隔 ms
     * @throws InterruptedException
     */
    private void init(long time) throws InterruptedException {
        while(true){
            lifeGame.game_cycle();
            lifeGame.getGameMap().printMap();
            System.out.println();

            sleep(time);
        }
    }

    /**
     * @Description 展示对外的开始方法
     * @param time 每次刷新的间隔 ms
     * @throws InterruptedException
     */
    public void start(long time) throws InterruptedException {
        init(time);
    }

    /**
     * Test，0101生命游戏测试（test）
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        GameTimer gameTimer = new GameTimer(new LifeGame(6,10,0.4));
        gameTimer.start(500);
    }
}
