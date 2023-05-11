package com.gurenkai.demo.aspect;

import com.gurenkai.demo.entity.Role;
import com.gurenkai.demo.entity.User;
import com.gurenkai.demo.persistence.BookDo;
import com.gurenkai.demo.repository.BookRepository;
import com.gurenkai.demo.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;


@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DataScopeHandlerTest {

    @Autowired
    private BookRepository bookRepository;


    @DisplayName("管理员不过滤")
    @Test
    public void adminScopeTest() {
        adminScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(1L).createBy(1L).deptId(1L).build();
        Long id = bookRepository.add(build);
        bookRepository.scopeFind();
        bookRepository.remove(id);
    }

    @DisplayName("只查询自己的")
    @Test
    public void selfScopeTest() {
        selfScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(2L).createBy(2L).deptId(1L).build();
        Long id = bookRepository.add(build);
        bookRepository.scopeFind();
        bookRepository.remove(id);
    }

    @DisplayName("查询部门的")
    @Test
    public void deptScopeTest() {
        deptScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(2L).createBy(2L).deptId(3L).build();
        Long id = bookRepository.add(build);
        bookRepository.scopeFind();
        bookRepository.remove(id);
    }

    @DisplayName("查询部门及以下")
    @Test
    public void deptChildrenScopeTest() {
        deptChildrenScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(2L).createBy(2L).deptId(3L).build();
        Long id = bookRepository.add(build);
        bookRepository.scopeFind();
        bookRepository.remove(id);
    }

    @DisplayName("自定义数据权限")
    @Test
    public void customScopeTest() {
        customScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(2L).createBy(2L).deptId(3L).build();
        Long id = bookRepository.add(build);
        bookRepository.scopeFind();
        bookRepository.remove(id);
    }

    @DisplayName("多角色数据权限")
    @Test
    public void multiRoleScopeTest() {
        multiRoleScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(2L).createBy(2L).deptId(3L).build();
        Long id = bookRepository.add(build);
        bookRepository.scopeFind();
        bookRepository.remove(id);
    }

    @DisplayName("表别名测试")
    @Test
    public void aliasScopeTest() {
        multiRoleScopeUser();
        BookDo build = BookDo.builder().title("老人与海").author("海明威").borrower(2L).createBy(2L).deptId(3L).build();
        Long id = bookRepository.add(build);
        bookRepository.aliasFind();
        bookRepository.remove(id);
    }

    public void adminScopeUser() {
        Role adminRole = Role.builder().roleName("管理员").roleKey("admin").dataScope(DataScopeHandler.DATA_SCOPE_ALL).build();
        User user = User.builder().id(1L).name("张三").deptId(1L).roles(Collections.singletonList(adminRole)).build();
        SecurityUtil.setLoginUser(user);
    }

    public void selfScopeUser() {
        Role adminRole = Role.builder().roleName("普通").roleKey("user").dataScope(DataScopeHandler.DATA_SCOPE_SELF).build();
        User user = User.builder().id(2L).name("李四").deptId(1L).roles(Collections.singletonList(adminRole)).build();
        SecurityUtil.setLoginUser(user);
    }

    public void deptScopeUser() {
        Role adminRole = Role.builder().roleName("普通").roleKey("user").dataScope(DataScopeHandler.DATA_SCOPE_DEPT).build();
        User user = User.builder().id(2L).name("李四").deptId(3L).roles(Collections.singletonList(adminRole)).build();
        SecurityUtil.setLoginUser(user);
    }

    public void deptChildrenScopeUser() {
        Role adminRole = Role.builder().roleName("普通").roleKey("user").dataScope(DataScopeHandler.DATA_SCOPE_DEPT_AND_CHILD).build();
        User user = User.builder().id(2L).name("李四").deptId(3L).roles(Collections.singletonList(adminRole)).build();
        SecurityUtil.setLoginUser(user);
    }

    public void customScopeUser() {
        Role adminRole = Role.builder().roleId(2L).roleName("普通").roleKey("user").dataScope(DataScopeHandler.DATA_SCOPE_CUSTOM).build();
        User user = User.builder().id(2L).name("李四").deptId(3L).roles(Collections.singletonList(adminRole)).build();
        SecurityUtil.setLoginUser(user);
    }

    public void multiRoleScopeUser() {
        Role role1 = Role.builder().roleId(2L).roleName("普通").roleKey("user").dataScope(DataScopeHandler.DATA_SCOPE_CUSTOM).build();
        Role role2 = Role.builder().roleId(2L).roleName("普通").roleKey("user").dataScope(DataScopeHandler.DATA_SCOPE_SELF).build();
        User user = User.builder().id(2L).name("李四").deptId(3L).roles(List.of(role1, role2)).build();
        SecurityUtil.setLoginUser(user);
    }
}