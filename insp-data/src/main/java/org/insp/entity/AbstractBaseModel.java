package org.insp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:35
 **/
@Data
public class AbstractBaseModel implements Serializable {
    private static final long serialVersionUID = -730412312169518243L;

    private Long id;
    private Date createTime;
    private Date updateTime;
    private Boolean isDelete;

}
