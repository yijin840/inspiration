package org.insp.third;

import lombok.RequiredArgsConstructor;
import org.insp.sdk.client.ProcessClient;
import org.springframework.stereotype.Component;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 16:34
 **/
@Component
@RequiredArgsConstructor
public class ThirdService {

    private final ThirdProcessClient thirdProcessClient;



}
