package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.train;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 火车票
 * </p>
 *
 * @author wangwq
 */
@Data
public class TrainInvoiceDTO implements Serializable {
    private static final long serialVersionUID = -5302816251876027446L;

    private String starting;
    private String destination;

    private String trainNum;
    private String startTime;

    private String seatNum;
    private String seatType;

    private String price;

    private String cardId;
    private String name;

    private String invocieNum;

    private String invoiceSalePlace;
}
