package boot.test.redis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RedisDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sourceId;
    private String itemId;
    public RedisDto(String sourceId, String itemId) {
        super();
        this.sourceId = sourceId;
        this.itemId = itemId;
    }
    @Override
    public String toString() {
        return "DataType [sourceId=" + sourceId + ", itemId=" + itemId + "]";
    }

}