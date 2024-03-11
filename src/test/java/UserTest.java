import cn.hutool.core.lang.UUID;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yijin.InspirationApplication;
import org.yijin.entity.User;
import org.yijin.mapper.UserMapper;

/**
 * @author YiJin840
 * @program inspiration
 * @description user test
 * @since 2024-03-04 12:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InspirationApplication.class)
@RequiredArgsConstructor
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertUser() {
        User user = new User();
        user.setName("yijin");
        user.setPassword("123456");
        System.out.println(user);
        userMapper.insertUser(user);
        user.setName(UUID.randomUUID().toString().substring(0, 5));
        userMapper.insertUser(user);
        System.out.println(user);
        user.setName(UUID.randomUUID().toString().substring(0, 5));
        userMapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    void getAllUsers() {
        userMapper.getAllUsers().forEach(System.out::println);
    }


}
