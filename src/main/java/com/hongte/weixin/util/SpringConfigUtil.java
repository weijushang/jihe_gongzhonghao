package com.hongte.weixin.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * spring通过配置获取properties文件中的内容
 *
 */
public class SpringConfigUtil extends PropertyPlaceholderConfigurer{
	
	/**
	 * 自定义map,用来装载property初始化后的键值对
	 */
	private static Map<String, Object> ctxPropertiesMap; 
	
	/**
	 * 重载该方法，将文件中键值对放入map中
	 */
    @Override 
    protected void processProperties( 
            ConfigurableListableBeanFactory beanFactoryToProcess, 
            Properties props) throws BeansException { 
        super.processProperties(beanFactoryToProcess, props); 
        ctxPropertiesMap = new HashMap<String, Object>(); 
        //
        for (Object key : props.keySet()) { 
            String keyStr = key.toString(); 
            String value = props.getProperty(keyStr); 
            ctxPropertiesMap.put(keyStr, value); //放入map
        }   
    } 
    /**
     * 通过key值从map中获取对应的value
     * @param name
     * @return
     */
    public static Object getContextProperty(String name) { 
        return ctxPropertiesMap.get(name); 
    }
    
    /**
     * 获取property中key对应的值
     * @param key
     * @return
     */
    public static String getProperties(String key){
    	return (String) getContextProperty(key);
    }
    
    /**
     * 获取值并设置参数值
     * @param key
     * @param param
     * @return
     */
    public static String getProperties(final String key,String... values){
		String msg = getProperties(key);
		return MessageFormat.format(msg, values);
	}
    
    
    /**** 
     * 用值填充属性文件中的占位符{0},{1}...,值的顺序必须和参数的顺序是一致的 
     * @param key 属性文件中的键值 
     * @param values 对应属性文件中的占位符的信息 
     * @return  将占位符中的信息对应填充后的字符串 
     */  
    public static String getProperty(String key,String... values){  
        //对应占位符参数值  
        String[] vs=values;  
        //属性文件中的值  
        String v=getProperty(key);  
          
        //如果没有参数  
        if(vs==null||vs.length==0){  
            return getProperty(key);  
        }  
          
        //如果属性文件中没有值,则返回空字符串  
        if(v==null){  
            return "";  
        }  
          
        StringBuffer buffer=new StringBuffer();  
          
        //遍历参数数组  
        for (int i = 0; i < vs.length; i++) {  
            //替换前清空原有替换值  
            buffer.delete(0, buffer.length());  
            Pattern pattern=Pattern.compile("\\{"+i+"\\}");  
            Matcher matcher=pattern.matcher(v);  
                while(matcher.find()){  
                      matcher.appendReplacement(buffer, vs[i]);  
                }  
            matcher.appendTail(buffer);  
            //进行下一次替换  
            v=buffer.toString();  
        }  
        //返回后替换的字符串  
        return buffer.toString();  
    }
}
