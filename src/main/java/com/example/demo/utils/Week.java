package com.example.demo.utils;

/**
 * 星期一 ~ 星期日
 *
 * @author lys
 * @ClassName: Week
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2015年3月5日 下午1:47:27
 */
public enum Week {

    /**
     * 周一
     */
    MONDAY("周一", "Monday", "Mon.", 1),
    /**
     * 周二
     */
    TUESDAY("周二", "Tuesday", "Tues.", 2),
    /**
     * 周三
     */
    WEDNESDAY("周三", "Wednesday", "Wed.", 3),
    /**
     * 周四
     */
    THURSDAY("周四", "Thursday", "Thur.", 4),
    /**
     * 周五
     */
    FRIDAY("周五", "Friday", "Fri.", 5),
    /**
     * 周六
     */
    SATURDAY("周六", "Saturday", "Sat.", 6),
    /**
     * 周日
     */
    SUNDAY("周日", "Sunday", "Sun.", 7);

    private String name_cn;
    private String name_en;
    private String name_enShort;
    private int number;

    private Week(String name_cn, String name_en, String name_enShort, int number) {
        this.name_cn = name_cn;
        this.name_en = name_en;
        this.name_enShort = name_enShort;
        this.number = number;
    }

    /**
     * 中文名获取
     *
     * @return
     * @Title: getChineseName
     * @Description: (这里用一句话描述这个方法的作用)
     * @date 2015年3月5日 下午1:48:13
     * @author lys
     */
    public String getChineseName() {
        return name_cn;
    }

    public String getName() {
        return name_en;
    }

    /**
     * 英文名获取
     *
     * @return
     * @Title: getShortName
     * @Description: (这里用一句话描述这个方法的作用)
     * @date 2015年3月5日 下午1:48:31
     * @author lys
     */
    public String getShortName() {
        return name_enShort;
    }

    /**
     * 编号获取
     *
     * @return
     * @Title: getNumber
     * @Description: (这里用一句话描述这个方法的作用)
     * @date 2015年3月5日 下午1:48:41
     * @author lys
     */
    public int getNumber() {
        return number;
    }
}