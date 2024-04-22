package org.insp.entity.model;

import org.insp.entity.AbstractBaseModel;

import java.math.BigDecimal;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:38
 **/
public class Goods extends AbstractBaseModel {
    private static final long serialVersionUID = 8637836543940513747L;

    private String name;

    private BigDecimal price;

    private Boolean isEnable;

}
