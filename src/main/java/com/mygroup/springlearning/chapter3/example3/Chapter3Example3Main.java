package com.mygroup.springlearning.chapter3.example3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Внедрение коллекций в класс
 */

@Service("injectCollection")
public class Chapter3Example3Main {

//    Аннотации только для случая component-scan
    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
//    @Resource(name = "list")

    @Autowired
    @Qualifier("list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter3/ch3ex3-app-context.xml");
        ctx.refresh();
        Chapter3Example3Main instance = (Chapter3Example3Main) ctx.getBean("injectCollection");
        instance.displayInfo();
        ctx.close();
    }

    public void displayInfo() {
        System.out.println("Map contents:\n");
        map.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));
        System.out.println("\nProperties contents:\n");
        props.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));
        System.out.println("\nSet contents:\n");
        set.forEach(value -> System.out.println("Value: " + value));
        System.out.println("\nList contents:\n");
        list.forEach(value -> System.out.println("Value: " + value));
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
