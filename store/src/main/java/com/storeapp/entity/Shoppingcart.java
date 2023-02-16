package com.storeapp.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2022-10-17
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Shoppingcart implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer productId;

    private Integer quantity;

    private Integer isorder;
}
