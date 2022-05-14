package Game;

import UI.GameStart;

/**
 * @author Qiezbg
 * @Description
 * @create 2022-05-06 15:37
 */
public class LifeGame {
    private GameMap gameMap;


    /**
     * @Description 传入3个参数是为了构造 map
     * @param maxX
     * @param maxY
     * @param ratio
     */
    public LifeGame(int maxX, int maxY, double ratio){
        init(maxX,maxY,ratio);
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    /**
     * @Description 初始化 GameMap
     * @param maxX
     * @param maxY
     * @param ratio
     */
    public void init(int maxX,int maxY,double ratio){
        gameMap = new GameMap(maxX,maxY,ratio);
    }

    /**
     * @Description 一次生命变化
     */
    public void game_cycle(){
        int maxX = gameMap.getMaxX();
        int maxY = gameMap.getMaxY();
        int[][] newMap = new int[maxX][maxY];

        for(int i=0;i<maxX;i++){
            for(int j=0;j<maxY;j++){
                int count = gameMap.get_neighbor_count(i,j);
                if(count == 3) newMap[i][j] = 1;
                else if(count == 2) newMap[i][j] = gameMap.get(i,j);
                else newMap[i][j] = 0;
            }
        }
        gameMap.setMap(newMap);
    }


    /**
     *  @Description 生命游戏
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        // 0101生命游戏 vertion 1.0
//        LifeGame lifeGame = new LifeGame(6, 10, 0.4);
//        lifeGame.getGameMap().printMap();
//        System.out.println();
//        GameTimer gameTimer = new GameTimer(lifeGame);
//        gameTimer.start(500);


        // GUI 生命游戏 vertion2.0
        LifeGame lifeGame = new LifeGame(100, 190, 0.1);
        GameStart gameStart = new GameStart(lifeGame,500);
    }
}
