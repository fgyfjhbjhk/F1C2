package com.restaurant.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author sdlg
 * @since 2025-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dishid", type = IdType.AUTO)
    private Integer dishid;
    private Integer did;
    private String dishname;

    private String price;

    private String description;


}
