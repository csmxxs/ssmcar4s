package com.zrcx.common;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
/** 
 * 字符串到日期的转换器 
 * @author manzhizhen 
 * 
 * 2018年1月03日 
 */  
public class DateUtil implements Converter<String, Date>{  
    
    public DateUtil() {  
        System.out.println("日期转换器出生啦");  
    }  
  
    @Override  
    public Date convert(String source) {  
        if(StringUtils.isBlank(source)) {  
            return null;  
        }  
         
        Date date = null;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        try {  
            date = format.parse(source.trim());  
        } catch (Exception e) {  
            try {  
                format = new SimpleDateFormat("yyyyMMddHHmmss");  
                date = format.parse(source.trim());  
            } catch (Exception e1) {  
                try {  
                    format = new SimpleDateFormat("yyyy-MM-dd");  
                    date = format.parse(source.trim());  
                } catch (Exception e2) {  
                }  
            }  
        }  
         
        return date;  
    }  
} 
