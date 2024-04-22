package org.insp.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.insp.entity.AbstractBaseModel;

import java.util.List;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:34
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends AbstractBaseModel {

    private static final long serialVersionUID = 3677596363551307776L;

    private String orderId;

    private String orderStatus;

    private List<Goods> goodsList;

}
