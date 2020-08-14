package cn.csq.bishe.form;

import lombok.Data;

/**
 * @ClassName : CategoryForm
 * @Author : CSQ
 * @Date: 2020-04-01 17:52
 * 类目表单
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;
}
