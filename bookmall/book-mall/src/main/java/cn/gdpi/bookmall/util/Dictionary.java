package cn.gdpi.bookmall.util;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 09:45
 ***/
public interface Dictionary {
    /**
     * 收集图类型
     */
    int BOOK_IMG_TYPE_COLLECT=2;

    /**
     * 详图1类型
     */
    int BOOK_IMG_TYPE_DETAIL1=3;
    /**
     * 大图1类型
     */
    int BOOK_IMG_TYPE_DETAIL1BIG=6;
    /**
     * 详图2类型
     */
    int BOOK_IMG_TYPE_DETAIL2=4;
    /**
     * 大图2类型
     */
    int BOOK_IMG_TYPE_DETAIL2BIG=7;

    /**
     * 详图3类型
     */
    int BOOK_IMG_TYPE_DETAIL3=5;
    /**
     * 大图3类型
     */
    int BOOK_IMG_TYPE_DETAIL3BIG=8;

    /**
     * 索引图类型
     */
    int BOOK_IMG_TYPE_INDEX=0;

    /**
     * 介绍图类型
     */
    int BOOK_IMG_TYPE_INTRO=1;



    //待处理；处理中；已发货；已交付


    String ORDER_PENDING="待处理";
    String ORDER_BEING_PROCESSED="处理中";
    String ORDER_SHIPPED="已发货";
    String ORDER_DELIVERED="已交付";
}
