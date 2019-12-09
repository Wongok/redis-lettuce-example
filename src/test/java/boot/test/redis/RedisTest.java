package boot.test.redis;

import boot.test.redis.config.TestRedisConfig;
import boot.test.redis.domain.RedisVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfig.class)
public class RedisTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void RedisTest() {
        String key = "testKey";
        String value = "testValue";

        redisTemplate.opsForValue().set(key, value);

        Object resultValue =  redisTemplate.opsForValue().get(key);

        System.out.println("value : " + redisTemplate.opsForValue().get(key));

        redisTemplate.delete(key);

        System.out.println("value : " + redisTemplate.opsForValue().get(key));

        if(!redisTemplate.hasKey(key)){
            System.out.println("deleted");
        }
    }
}
