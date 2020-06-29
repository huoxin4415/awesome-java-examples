package com.huoxin4415.aje.core.javax.management;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.management.DescriptorKey;

/**
 * Descriptors allow you to give additional information about MBeans to management clients. 
 * 
 * This annotation supplies the name of the creator of the MBean interface. 
 * A new field author will be added to the MBeanInfo Descriptor with the value defined by 
 * the @Author annotation. 
 * 
 * @author linan
 * 
 */
@Documented 
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface Author { 
    @DescriptorKey("author") 
    String value(); 
} 
