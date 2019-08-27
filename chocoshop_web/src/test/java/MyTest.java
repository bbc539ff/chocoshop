import com.chocoshop.Application;
import com.chocoshop.model.UserInfo;
import com.chocoshop.service.UserInfoService;
import com.chocoshop.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {
    @Autowired
    UserInfoService userInfoService;

    @Test
    public void insertTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("user1");
        userInfo.setSalt(Utils.generateSalt("123456"));
        userInfo.setPassword(Utils.generatePwd("123456", userInfo.getSalt()));
        userInfo.setState(true);
        userInfo.setUsername("yh1");
        userInfo.setPhone("13411112222");
        userInfo.setEmail("13411112222@mail.com");
        userInfo.setCreated(new Date());
        userInfo.setUpdated(new Date());
        userInfo.setGender(false);
        userInfo.setAddress("GuangDong");
        userInfo.setPhoto("");
        userInfoService.createUser(userInfo);
    }
}
