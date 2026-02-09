package course.stock.constant;

public class StockConstant {

    public static final String QSTOCK = "QStock:";

    /**
     * 定义校验码的前缀
     */
    public static final String CHECK_PREFIX = QSTOCK + "Check:";

    /**
     * http请求头携带Token信息key
     */
    public static final String TOKEN_HEADER = QSTOCK + "Authorization:";

    /**
     * 缓存股票相关信息的cacheNames命名前缀
     */
    public static final String STOCK = QSTOCK + "Cache:";
}