package Game;

import java.util.Random;

/**
 * @author Qiezbg
 * @Description
 * @create 2022-05-06 15:37
 */
public class GameMap {
    private int[][] map;
    private int maxX;
    private int maxY;
    private double ratio;
    private Random random = new Random();

    /**
     * @Description 默认初始化，地图 100*100，比例 0.5
     */
    public GameMap() {
        map = new int[100][100];
        maxX = 100;
        maxY = 100;
        ratio=0.5;
        setMap();
    }

    /**
     * @Description 自定义构造方法
     * @param maxX
     * @param maxY
     * @param ratio
     */
    public GameMap(int maxX, int maxY, double ratio)
    {
        map = new int[maxX][maxY];
        this.maxX = maxX;
        this.maxY = maxY;
        this.ratio = ratio;
        setMap();
    }

    /**
     * @Description 返回地图边的 x 大小
     * @return
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * @Description 返回地图边的 y 大小
     * @return
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     *  @Description 生成随机化地图
     */
    private void setMap(){
        int n = (int) (ratio*100);
        for(int i=0;i<maxX;i++){
            for(int j=0;j<maxY;j++){
                map[i][j] = random.nextInt(100)>=n? 0:1;
            }
        }
    }

    /**
     *  @Description 重新生成随机化地图
     */
    public void reset(){
        setMap();
    }

    /**
     * @Description 返回(x,y)点的值， 0 ，1 ,生或死
     * @param x
     * @param y
     * @return
     */
    public int get(int x,int y){
        return map[x][y];
    }

    /**
     * @Description 设置生或死
     * @return
     */
    public void set(int x,int y,int val) {
        map[x][y] = val;
    }

    // 地图的set get 方法
    public void setMap(int[][] map) {
        this.map = map;
    }
    public int[][] getMap() {
        return map;
    }

    /**
     * @Description 统计周围8个点的生命数
     * @param x
     * @param y
     * @return
     */
    public int get_neighbor_count(int x, int y){
        int count=0;
        if(x-1>=0){
            if(y-1>=0 && get(x-1,y-1) ==1) count++;
            if(get(x-1,y) ==1 ) count++;
            if(y+1<maxY && get(x-1,y+1) ==1 ) count++;
        }
        if(y-1>=0 && get(x,y-1) ==1 ) count++;
        if(y+1<maxY && get(x,y+1) ==1 ) count++;
        if(x+1<maxX){
            if(y-1>=0 && get(x+1,y-1) ==1) count++;
            if(get(x+1,y) == 1) count++;
            if(y+1<maxY && get(x+1,y+1) ==1 ) count++;
        }
        return count;
    }

    /**
     *  打印 map --> 0101
     */
    public void printMap(){
        for(int[] a:map){
            for(int i:a) System.out.print(i);
            System.out.println();
        }
    }

    /**
     *  @Description 画一次初始的图
     * @param args
     */
    public static void main(String[] args) {
        GameMap gameMap = new GameMap(10,5,0.2);
        gameMap.printMap();
    }
}
