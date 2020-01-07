package com.charon.boot.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 实现list之间的转化
 * @author: charon
 * @create: 2020-01-06 23:03
 **/
public class DozerUtils {

    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for (Iterator i$ = sourceList.iterator(); i$.hasNext();){
            Object sourceObject = i$.next();
            Object destinationObject = dozerBeanMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}