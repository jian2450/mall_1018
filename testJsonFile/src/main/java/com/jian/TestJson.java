package com.jian;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jian.bean.Class1;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-26 0:24
 */
public class TestJson {

    @Test
    public void testGsonObj(){

        //������json�ַ�����ת
        Class1 class1 = new Class1(1, "�ֻ�");
        System.out.println(class1);

        //����gson����
        Gson gson = new Gson();
        String json = gson.toJson(class1);
        System.out.println(json);

        Class1 class11 = gson.fromJson(json, Class1.class);
        System.out.println(class11);
    }

    @Test
    public void testGsonList(){
        //������json�ַ�����ת
        ArrayList<Class1> list = new ArrayList<>();
        list.add(new Class1(1,"����"));
        list.add(new Class1(2,"�ֻ�"));
        System.out.println(list);

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);

       // Class1 class1 = gson.fromJson(json, Class1.class); //�쳣

        Object o = gson.fromJson(json, (new TypeToken<List<Class1>>() {}.getType()));
        System.out.println(o);
    }

    @Test
    public void testJsonLib(){
        //������json�ַ�����ת
        Class1 class1 = new Class1(1, "�ֻ�");
        System.out.println(class1);

        JSONObject jsonObject = JSONObject.fromObject(class1);
        String str = jsonObject.toString();
        System.out.println(str);

        Object o = JSONObject.toBean(jsonObject, Class1.class);
        System.out.println(o);

    }

    @Test
    public void testJsonLibList(){
        //������json�ַ�����ת
        ArrayList<Class1> list = new ArrayList<>();
        list.add(new Class1(1,"����"));
        list.add(new Class1(2,"�ֻ�"));
        System.out.println(list);

        JSONArray jsonArray = JSONArray.fromObject(list);
        String str = jsonArray.toString();
        System.out.println(str);

        //����class��ָ����Ԫ�صĴ�Class
        ArrayList<Class1> list1 = (ArrayList<Class1>)JSONArray.toCollection(jsonArray, Class1.class);
        System.out.println(list1);

    }

    @Test
    public void testFastJson(){
        //������json�ַ�����ת
        Class1 class1 = new Class1(1, "�ֻ�");
        System.out.println(class1);

        String str = JSON.toJSONString(class1);
        System.out.println(str);

        Class1 class11 = JSON.parseObject(str, Class1.class);
        System.out.println(class11);
    }

    @Test
    public void testFastJsonList(){
        //������json�ַ�����ת
        ArrayList<Class1> list = new ArrayList<>();
        list.add(new Class1(1,"����"));
        list.add(new Class1(2,"�ֻ�"));
        System.out.println(list);

        String str = JSON.toJSONString(list);
        System.out.println(str);

        List<Class1> list1 = JSON.parseArray(str, Class1.class);
        System.out.println(list1);


    }
}
