package 集合.斗地主案例;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 模拟斗地主洗牌发牌
 * 1，组装54张扑克牌
 * 2，将牌打乱
 * 3，三个玩家参与游戏，每人17张，并留3张底牌
 * 4，查看手牌和底牌
 */
public class Poker {
    public static void main(String[] args) {
        //准备花色
        ArrayList<String> color = new ArrayList<>();
        Collections.addAll(color,"♥","♠","♦","♣");
        //准备数字
        ArrayList<String> number = new ArrayList<>();
        Collections.addAll(number,"A","2","3","4","5","6","7","8","9","10","J","Q","K");
        //将数字和花色进行匹配

    }
}
