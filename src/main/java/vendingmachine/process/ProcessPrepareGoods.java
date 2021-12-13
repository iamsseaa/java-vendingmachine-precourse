package vendingmachine.process;

import vendingmachine.user.*;

import java.util.List;

public class ProcessPrepareGoods {
    public static String goods;
    public static List<String[]> goodsArray;

    public static void inputGoods() {
        goods = User.inputGoods();
    }

    public static void checkGoods() {
        UserGoodsValidation.checkUserGoodsValidation(goods);
    }

    public static void removeBracket() {
        goods.replace(ProcessConstant.SQUARE_BRACKETS_OPEN, "");
        goods.replace(ProcessConstant.SQUARE_BRACKETS_CLOSE, "");
    }

    public static String[] toArray() {
        String[] goodsArray = goods.split(ProcessConstant.GOODS_DELIMITER);
        return goodsArray;
    }

    public static void toGoodsArray() {
        String[] array = toArray();

        for (String oneGoods : array) {
            String[] goods = oneGoods.split(",");
            goodsArray.add(goods);
        }
    }

    public static void checkGoodsEachValidation() {
        for (String[] goods : goodsArray) {
            UserGoodsNameValidation.checkGoodsNameValidation(goods[0]);
            UserGoodsPriceValidation.checkGoodsPriceValidation(goods[1]);
            UserGoodsQuantityValidation.checkGoodsQuantityValidation(goods[2]);
        }
    }

}