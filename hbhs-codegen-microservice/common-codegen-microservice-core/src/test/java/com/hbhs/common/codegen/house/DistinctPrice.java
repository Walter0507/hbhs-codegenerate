package com.hbhs.common.codegen.house;

import lombok.Data;

import java.util.Date;

@Data
public class DistinctPrice {
    private String id;
    private String provinceId;
    private String cityId;
    private String distinctId;
    private Date loadDay;
    private Long sellingCount;
    private Long sellingAvgPrice;
}
