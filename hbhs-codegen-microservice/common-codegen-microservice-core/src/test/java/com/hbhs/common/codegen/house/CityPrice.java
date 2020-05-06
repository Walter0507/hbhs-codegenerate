package com.hbhs.common.codegen.house;

import lombok.Data;

import java.util.Date;

@Data
public class CityPrice {
    private String id;
    private String provinceId;
    private String cityId;
    private Date loadDay;
    private Long sellingCount;
    private Long sellingAvgPrice;
}
