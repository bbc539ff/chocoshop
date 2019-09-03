import com.chocoshop.Application;
import com.chocoshop.mapper.CategoryMapper;
import com.chocoshop.mapper.SysPermissionMapper;
import com.chocoshop.mapper.SysRoleMapper;
import com.chocoshop.model.*;
import com.chocoshop.service.CategoryService;
import com.chocoshop.service.GoodsService;
import com.chocoshop.service.AdminService;
import utils.Utils;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {
    @Autowired
    AdminService adminService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void insertTest(){
        Admin admin = new Admin();
        admin.setAdminNickname("user1");
        admin.setAdminSalt(Utils.generateSalt("123456"));
        admin.setAdminPassword(Utils.generatePwd("123456", admin.getAdminSalt()));
        admin.setAdminState(true);
        admin.setAdminName("yh123");
        admin.setAdminPhone("13411112222");
        admin.setAdminEmail("13411112222@mail.com");
        admin.setAdminCreateTime(new Date());
        admin.setAdminUpdateTime(new Date());
        admin.setAdminGender(false);
        admin.setAdminAddress("GuangDong");
        admin.setAdminPhoto("");
        adminService.addAdmin(admin);
    }

    @Test
    public void searchTest(){
        Category category = new Category();
        category.setCategoryParent(1L);

        System.out.println(categoryMapper.search(category));
    }

    @Test
    public void catSelevtTest(){
        for(Category category : categoryService.getAllCategory()){
            System.out.println(category);
        }
    }

    @Test
    public void goodsSelevtTest(){
        for(Goods goods : goodsService.showAllGoods()){
            System.out.println(goods);
        }
    }

    @Test
    public void func(){
        PageHelper.startPage(1, 5);
        for(Category category : categoryService.getAllCategory()){
            System.out.println(category);
        }
    }

    @Test
    public void adminTest(){
        System.out.println(adminService.findByAdminName("yh1"));
    }

    @Autowired
    public SysRoleMapper sysRoleMapper;

    @Test
    public void sysroleTest(){
        for(SysRole sysRole : sysRoleMapper.selectByAdminId((long) 3)){
            System.out.println(sysRole);
        }
    }

    @Autowired
    public SysPermissionMapper sysPermissionMapper;
    @Test
    public void syspermTest(){
        for(SysPermission sysPermission : sysPermissionMapper.selectByRoleId(1)){
            System.out.println(sysPermission);
        }
    }
}
