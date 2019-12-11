package boot.test.redis;

import boot.test.redis.config.TestRedisConfig;
import boot.test.redis.domain.RedisDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfig.class)
public class RedisTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void RedisTest() {
        String key = "testKey";
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();

        RedisDto setData = new RedisDto("park", "1232");

        vop.set(key, setData);

        RedisDto getData = (RedisDto) vop.get(key);

        System.out.println("GET-ItemId : " + getData.getItemId());      // park
        System.out.println("GET-SourceId : " + getData.getSourceId());  // 1232

        redisTemplate.delete(key);

        RedisDto getData2 = (RedisDto) vop.get(key);                    // null

        System.out.println("GET-getData2 : " + getData2);
    }
}
