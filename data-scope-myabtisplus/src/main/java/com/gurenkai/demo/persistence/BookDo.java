package com.gurenkai.demo.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("demo_data_scope")
public class BookDo {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String author;

    private Long borrower;

    private Long createBy;

    private Long deptId;

}
