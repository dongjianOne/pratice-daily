package com.dong.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 运营管理>设置 参数
 * </p>
 *
 * @author auto generator
 * @since 2019-06-22
 */
@Data
public class ParaKeyValue implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * 参数KEY中文名称 （例如：工行，农行，建行..)
     */
    private String paraKey;

    /**
     * 参数代码   标识参数类别
     */
    private String paraCode;

    /**
     * 参数值      (例如：工农建）
     */
    private String paraValue;

    /**
     * 参数说明   （例如：需要核对的托管行）
     */
    private String paraNote;

    /**
     * 唯一id
     */
    private String id;

    /**
     * 字典代码
     */
    private String fcode;


}
