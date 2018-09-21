package com.zyouke.solr.client.solrj.util;

import com.carrotsearch.randomizedtesting.RandomizedRunner;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

/**
 * @Author: zhoujun
 * NamedList工具测试
 */
public class NamedListTest {

    @Test
    public void testList(){
        NamedList<String> entries = new NamedList<>();
        entries.add("aaa_name","aaa_val");
        entries.add("bbb_name","bbb_val");
        entries.add("ccc_name","ccc_val");

        System.out.println(entries.getName(0));
        System.out.println(entries.getAll("bbb_name"));
        System.out.println(entries.toString());
    }

    @Test
    public void testMap(){
        NamedList<String> entries = new NamedList<>(new HashMap<>());
        entries.add("aaa_name","aaa_val");
        entries.add("bbb_name","bbb_val");
        entries.add("ccc_name","ccc_val");

        System.out.println(entries.getName(0));
        System.out.println(entries.getAll("bbb_name"));
        System.out.println(entries.toString());
    }



}
