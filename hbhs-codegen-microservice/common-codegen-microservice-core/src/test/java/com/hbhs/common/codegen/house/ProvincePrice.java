package com.hbhs.common.codegen.house;

import lombok.Data;

import java.util.Date;

@Data
public class ProvincePrice{
    private String id;
    private String provinceId;
    private Date week;
    private Date month;
    private Long sellingCount;
    private Long sellingAvgPrice;
}