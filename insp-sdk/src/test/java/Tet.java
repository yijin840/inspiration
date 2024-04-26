import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Test;

import java.io.Serializable;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/26 17:48
 **/
public class Tet {

    @Test
    public void tet() {
        SerTest st = JSONObject.parseObject("{'success':false}", SerTest.class);
        if(!st.getSuccess()) {
            throw new RuntimeException("123");
        }
    }


    @Data
    public static class SerTest implements Serializable {

        private static final long serialVersionUID = 5283962996825192831L;

        private Boolean success;
    }

}
