package org.chm.boot.util;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by charming on 2017/7/6.
 */
public class JsonPropertySourceLoader implements PropertySourceLoader {

    public String[] getFileExtensions() {
        // 配置文件格式（扩展名）
        return new String[] { "json" };
    }

    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        // 处理机制参考PropertiesPropertySourceLoader
        // 无论profile有没有值，底层都会尝试先执行 load(String name, Resource resource, null)，所以这个地方之间判断等于null即可。
        // 当前版本springboot-1.5.2（后续版本未知）详见 ConfigFileApplicationListener 的 445 行
        if (profile == null) {
            Map<String, Object> result = mapPropertySource(resource);
            return new MapPropertySource(name, result);
        }
        return null;
    }

    /**
     * 解析Resource为Map
     *
     * @param resource
     * @return
     * @throws IOException
     *
     * @create 2017年4月20日
     */
    private Map<String, Object> mapPropertySource(Resource resource) throws IOException {
        if (resource == null) {
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>();
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = parser.parseMap(readFile(resource));
        nestMap("", result, map);
        return result;
    }



    /**
     * 读取Resource文件内容为字符串
     *
     * @param resource
     * @return
     * @throws IOException
     * @create 2017年4月20日
     */
    private String readFile(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        List<Byte> byteList = new LinkedList<Byte>();
        byte[] readByte = new byte[1024];
        int length;
        while ((length = inputStream.read(readByte)) > 0) {
            for (int i = 0; i < length; i++) {
                byteList.add(readByte[i]);
            }
        }
        byte[] allBytes = new byte[byteList.size()];
        int index = 0;
        for (Byte soloByte : byteList) {
            allBytes[index] = soloByte;
            index += 1;
        }
        return new String(allBytes, "UTF-8");
    }

    /**
     * 处理map（map中可能还嵌套map，递归处理），最终输出一个非嵌套的map
     *
     * @param prefix
     *            前缀
     * @param result
     *            处理后的map
     * @param map
     *            处理前的map
     *
     * @create 2017年4月20日
     */
    @SuppressWarnings("unchecked")
    private void nestMap(String prefix, Map<String, Object> result, Map<String, Object> map) {
        if (prefix.length() > 0) {
            prefix += ".";
        }
        for (Map.Entry<String, Object> entrySet : map.entrySet()) {
            if (entrySet.getValue() instanceof Map) {
                nestMap(prefix + entrySet.getKey(), result, (Map<String, Object>) entrySet.getValue());
            } else {
                result.put(prefix + entrySet.getKey().toString(), entrySet.getValue());
            }
        }
    }
}