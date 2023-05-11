package com.gurenkai.demo.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gurenkai.demo.annotation.DataScope;
import com.gurenkai.demo.mapper.BookMapper;
import com.gurenkai.demo.persistence.BookDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookRepository {

    private final BookMapper bookMapper;

    public Long add(BookDo book) {
        bookMapper.insert(book);
        return book.getId();
    }

    public List<BookDo> normalFind() {
        return bookMapper.selectList(null);
    }

    @DataScope(userField = "borrower")
    public List<BookDo> scopeFind() {
        LambdaQueryWrapper<BookDo> queryWrapper = Wrappers.lambdaQuery(BookDo.class).eq(BookDo::getTitle, "老人与海");
        return bookMapper.selectList(queryWrapper);
    }

    @DataScope(deptAlias = "dds", userAlias = "dds")
    public List<BookDo> aliasFind() {
        return bookMapper.aliasTestSelect();
    }

    public int remove(Long id) {
        return bookMapper.deleteById(id);
    }

}
