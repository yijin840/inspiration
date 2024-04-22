import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 17:53
 **/
public class TestTimeStamp {

    @Test
    public void test() {

        /*
           1     5
           1  a  5
           1 b a 5
           1 b a c 5
           1 d b a c 5
         */
        String start = "1712800000";
        String end = "1712829088";
        List<Map.Entry<Long, Long>> result = getResult(start, end, 5);
        for (Map.Entry<Long, Long> entry : result) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    public List<Map.Entry<Long, Long>> getResult(String start, String end, int count) {
        Long sl = Long.valueOf(start);
        Long el = Long.valueOf(end);

        List<List<Map.Entry<Long, Long>>> res = new ArrayList<>();
        List<Map.Entry<Long, Long>> rr = new ArrayList<>();
        if (count == 1) {
            rr.add(new AbstractMap.SimpleEntry<>(sl, el));
            return rr;
        }
        while (res.size() <= count) {
            List<Map.Entry<Long, Long>> list = new ArrayList<>();
            if (res.isEmpty()) {
                long mid = (sl + el) / 2;
                list.add(new AbstractMap.SimpleEntry<>(sl, mid));
                list.add(new AbstractMap.SimpleEntry<>(mid, el));
                res.add(list);
            } else {
                //上次一次最后一个区间，从左到右开始分区间
                List<Map.Entry<Long, Long>> entries = res.get(res.size() - 1);
                System.out.println(entries);
                for (int i = 0; i < entries.size(); i++) {
                    Map.Entry<Long, Long> entry = entries.get(i);
                    long mid = (entry.getKey() + entry.getValue()) / 2;
                    list.add(new AbstractMap.SimpleEntry<>(entry.getKey(), mid));
                    if (list.size() + (entries.size() - i) > count) {
                        rr.addAll(list);
                        rr.addAll(entries.subList(i + 1, entries.size()));
                        return rr;
                    }
                    list.add(new AbstractMap.SimpleEntry<>(mid, entry.getValue()));
                    if (list.size() + (entries.size() - i) > count) {
                        rr.addAll(list);
                        rr.addAll(entries.subList(i + 1, entries.size()));
                        return rr;
                    }
                }
                res.add(list);
            }
        }

        throw new RuntimeException("error");
    }

}
