package design.pattern.strategy;

import java.util.Random;

/**
 * @program: paste
 * @description: 如何赢的策略
 * @author: MagnetoWang
 * @create: 2018-07-23 11:38
 **/
public class WinningStrategy implements Strategy{
    private Random random;
    private boolean won = false;
    private Hand prevHand;
    public WinningStrategy(int seed) {
        random = new Random(seed);
    }
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }
    public void study(boolean win) {
        won = win;
    }
}
