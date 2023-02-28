package com.example.jsr303.entity;

import com.example.jsr303.validate.annocation.Json;
import com.example.jsr303.validate.annocation.ListVale;
import com.example.jsr303.validate.group.AddGroup;
import com.example.jsr303.validate.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class Student {

    /**
     * id
     */
    @NotNull(message = "id不能为空",groups = UpdateGroup.class)
    @Null(message = "id必须为空",groups = AddGroup.class)
    private Long id;
    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空",groups = AddGroup.class)
    private String name;
    /**
     * 性别 1 代表男 2代表女  3代表未知
     */
    @ListVale(vals={"1","2","3"},message="性别必须是1，2，3",groups={AddGroup.class,UpdateGroup.class})
    private String sex;

    @NotEmpty(message = "url不能为空",groups = AddGroup.class)
    @URL(message = "url不合法",groups = {AddGroup.class,UpdateGroup.class})
    private String url;

    @Json(message="Json数据校验不合法",groups={AddGroup.class,UpdateGroup.class})
    private String json;

    @NotNull(message = "排序不能为空",groups = AddGroup.class)
    @Min(value = 1,message = "排序不合法",groups ={AddGroup.class,UpdateGroup.class})
    private Integer orderBy;

    /**
     * 头像地址
     */
    private String logoUrl;
}
