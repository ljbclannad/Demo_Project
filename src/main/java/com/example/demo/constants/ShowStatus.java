package com.example.demo.constants;

/**
 * Created by panjj on 2017/7/23.
 */
public enum ShowStatus {

    PAY_WAIT("待付款"),
    PAY_ING("付款中"),
    PAY_SUCCESS("付款成功"),
    PAY_FAIL("付款失败"),
    CLOSE("交易关闭"),
    REFUND_WAIT("待退款"),
    REFUND_ING("退款中"),
    REFUND_FAIL("退款失败"),
    REFUND_FINISH("退款成功");

    private String value;

    ShowStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
