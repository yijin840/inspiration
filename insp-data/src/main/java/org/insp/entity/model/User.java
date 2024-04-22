package org.insp.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.insp.entity.AbstractBaseModel;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:34
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractBaseModel {
    private static final long serialVersionUID = -3804216237225804684L;

    private String username;

    private String password;

    private String name;

}
