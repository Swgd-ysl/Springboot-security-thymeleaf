package com.huashuohair.app.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Map;

/**
 * �ַ���������
 * @author ��ˮ
 *
 */
public class StringUtil{
	
	public static final String STR_FRONT = "front"; //�ַ���ǰ��
	public static final String STR_BACK = "back"; //�ַ�������
	/** ���ַ����� */
	public static final String EMPTY_STRING = "";
	/**
	 * 
	 * description: ȥ���ַ���ǰ��Ŀո���<code>str</code>Ϊ<code>null</code>,���ؿմ�
	 * @param str
	 * @return
	 */ 
    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }
    /**
     * 
     * description:ȥ���ַ�������ո�
     * @param str
     * @return
     */ 
    public static String trim(Object obj) {
    	return obj == null ? "" : trim(obj.toString());
    }
    /**
     * 
     * description: �ж�<code>str</code>�Ƿ�Ϊ�մ���<code>null</code>
     * @param str
     * @return ��Ϊ�մ���<code>null</code>����<code>true</code>,���򷵻�<code>false</code>
     */
    public static boolean isEmpty(String str){
    	str = trim(str);
    	if("".equals(str))
    		return true;
    	else
    		return false;
    }
    /**
     * 
     * description: �ж�<code>str</code>�Ƿ�Ϊ�մ���<code>null</code>
     * @param str
     * @return ��Ϊ�մ���<code>null</code>����<code>false</code>,���򷵻�<code>true</code>
     */
    public static boolean isNotEmpty(String str){
    	return !isEmpty(str);
    }
    /**
     * 
     * description: ȥ��obj��string�����ֶ�ֵ�Ŀո���objΪString,��objȥ�ո�󷵻�
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Object trimObjectFields(Object obj){
    	if(obj == null )
    		return "";
    	Class<? extends Object> cls = obj.getClass();
    	if(obj instanceof String)
    		return trim(obj.toString());
    	Field[] fields = cls.getDeclaredFields();
    	try{
	    	for(Field field : fields){
	    		field.setAccessible(true);
	    		if (!Modifier.isStatic(field.getModifiers()) && Modifier.isPrivate(field.getModifiers())) {
	    			Object value = field.get(obj);
	    			if(value instanceof String && null != value){
		    			String resultStr = StringUtil.trim((String)value);
		    			String name = field.getName();
		    			String setMethodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
		    			Method setMethod = obj.getClass().getMethod(setMethodName, String.class);
		    		    setMethod.setAccessible(true);
		    			setMethod.invoke(obj, resultStr);
		    		}
				}
	    		
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
    }
    /**
     * 
     * description: ȥ��obj��string�����ֶ�ֵ�Ŀո���objΪString,��objȥ�ո�󷵻�
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Object trimObjectFieldsOptional(Object obj){
    	if(obj == null )
    		return "";
    	Class cls = obj.getClass();
    	if(obj instanceof String)
    		return trim(obj.toString());
    	Field[] fields = cls.getDeclaredFields();
    	try{
	    	for(Field field : fields){
	    		String type = field.getType().getSimpleName().toString();
	    		String name = field.getName();
	    		if("String".equals(type)){
	    			try {
	    				String getMethod = "get"+name.substring(0, 1).toUpperCase()+name.substring(1);
	    				Method get = cls.getMethod(getMethod);
	    				String value = "";
	    				Object objvalue = get.invoke(obj);
	    				if(null!=objvalue){
	    					value = trim(objvalue.toString());
	    				}
	    				String setMethod = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
	    				Method set = cls.getMethod(setMethod,String.class);
	    				set.invoke(obj, value);
	    			} catch (Exception e) {
	    				
	    			}
	    		}
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
    }
    /**
     * ȥ��map��string�����ֶ�ֵ�Ŀո���valueΪString,��objȥ�ո�󷵻�
     * @param obj
     * @return
     */
	@SuppressWarnings("unchecked")
	public static Map trimMap(Map map){
    	if(map == null )
    		return null;
    	try{
    		Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				if (value instanceof String) {
					String valueStr = StringUtil.trim((String)value);
					map.put(key, valueStr);
				} else {
					if (value instanceof Map) {
						value = trimMap((Map)value);
					} else {
						value = StringUtil.trimObjectFields(value);
						map.put(key, value);
					}
				}
			} 
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return map;
    }
	/**
	 * ��ԭ����ǰ����ߺ�������ַ�
	 * @param str ԭ�ַ���
	 * @param len �������ַ�������
	 * @param fillChar �����ַ�
	 * @param position ����λ�ã�Ĭ��Ϊԭ����ǰ��
	 * @return
	 * @see:
	 */
	public static String replenish(String str, int len, char fillChar, String position){
		str = trim(str);
		if (str.length() >= len) {
			return str;
		}
		
		String addStr = "";
		for (int i = str.length(); i < len; i++) {
			addStr += fillChar;
		}
		
		if (position.equals(STR_FRONT)) {
			str = addStr + str;
		} else {
			str = str + addStr;
		}
		
		return str;
		
	}
	/**
	 * ����ַ���Ϊ16λ
	 * @param str ԭ�ַ���
	 * @param fillChar �����ַ�
	 * @return
	 * @see:
	 */
	public static String fillThString16(String str,  String fillChar){
		int len=16;
		str = trim(str);
		if (str.length() >= 16) {
			return str.substring(0,16);
		}
		
		String addStr = "";
		for (int i = str.length(); i < len; i++) {
			addStr += fillChar;
		}
			str = str + addStr;
		
		return str;
		
	}
	public static String subString(String str,int maxLength){
		return str.substring(0,maxLength);
	}
	 /**
     * �ж��ַ��������Ƿ����ĳ��ֵ
     */
    public static boolean isOverMaxLength(String str,int maxLength){
    	if(str.getBytes().length>maxLength){
    		return true;
    	}
    	return false;
    }
    
    /**
     * ����·����ȡ�ļ���
     * @param path
     * @return
     */
    public static String getFileName(String path){
    	path = trim(path);
		if("".equals(path)){
			return path;
		}
		String srcFileName="";
		int post1 = path.lastIndexOf("/");
		int post2 = path.lastIndexOf("\\");
		if(post1<post2){
			srcFileName = path.substring(post2+1);
		}else{
			srcFileName = path.substring(post1+1);
		}
		return srcFileName;
    }
    
	/**
	 * ʹ��java������ʽȥ�������.��0
	 * @param s
	 * @return 
	 */
	public static String subZeroAndDot(String s){
		if(s.indexOf(".") > 0){
			s = s.replaceAll("[0]*$", "");//ȥ�������0
			if (String.valueOf(s.charAt(s.length() - 1)).equals(".")) {
				s = s.substring(0, s.length() - 1);
			}
			//s = s.replaceAll("[.]$", "");//�����һλ��.��ȥ��
		}
		return s;
	}
	/**
	 * desc:���������ַ�������%��<
	 * <p>�����ˣ�chengliuyun , Feb 21, 2013 4:30:42 PM</p>
	 * @param input
	 * @return
	 */
	public static String filterString(String input) {
		if (input == null || "".equals(input.trim()) || "null".equals(input.trim())) {
			return "";
		}
		// ȥ������htmlԪ��, sql Ԫ��
		String ret = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>",
				"").replaceAll("[(/>)<]", "").replace("%", "").
				replaceAll(" and ", "").replaceAll(" AND ", "").replaceAll(" or ", "").replaceAll(" OR ", "");
		return ret;
	}
	/**
     * �ж�һ���ַ���Ascill�ַ����������ַ����纺���գ������ַ���
     * @param char c, ��Ҫ�жϵ��ַ�
     * @return boolean, ����true,Ascill�ַ�
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }
    /**
     * �õ�һ���ַ����ĳ���,��ʾ�ĳ���,һ�����ֻ��պ��ĳ���Ϊ2,Ӣ���ַ�����Ϊ1
     * @param String s ,��Ҫ�õ����ȵ��ַ���
     * @return int, �õ����ַ�������
     */
    public static int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }
    /**
     * ��ȡ����ַ��ĳ���,��������Ӣ��,������ֲ����ã�����ȡһ���ַ�λ
     * @author patriotlml
     * @param String origin, ԭʼ�ַ���
     * @param int len, ��ȡ����(һ�����ֳ��Ȱ�2���)
     * @return String, ���ص��ַ���
     * @throws Exception 
     */
    public static String subMultString(String origin, int len) throws Exception {
        if (origin == null || origin.equals("")||len<1)
            return "";
        byte[] strByte = new byte[len];
        if (len > length(origin)){
            return origin;}
        System.arraycopy(origin.getBytes("GBK"), 0, strByte, 0, len);
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = (int) strByte[i];
            if (value < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? ++len : --len;
        }
        return new String(strByte, 0, len, "GBK");
    }
    
	/**
	 * �ؼ�����* �滻
	 * ����  value >= 15 λ     ǰ6λ����  �м�*  ��4λ����    
	 * @param value
	 * @return 
	 */
    public static String replaceChar(String value){
		if(StringUtil.isEmpty(value)){
			return "";
		}else{
			if(value.length() >= 15){ //ǰ6λ����  �м�*  ��4λ���� 
		    	String replaceHeadStr = value.substring(0,6);
		    	String replaceTailStr = value.substring(value.length()-4);
		    	String dimStr = lStr("",'*',value.length()-10);
		    	return replaceHeadStr+dimStr+ replaceTailStr;
			}else{
				return "";
			}
		}
	}
	/**
	 * �󲹳�char
	 */
    public static String lStr(String s, char ch, int width) {
        if (s.length() < width) { // ��Ҫǰ�油'0'
            while (s.length() < width)
                s = ch + s;
        } else { // ��Ҫ����λ����
            s = s.substring(s.length() - width, s.length());
        }
        return s;
    }
    
    /**                                                                                                            
      * ȡָ���ַ������Ӵ�����ȡ�ַ����� 
      * �������������β����ʼ���㡣����ַ���Ϊ<code>null</code>���򷵻�<code>null</code>��                              
      * StringUtil.substring(null, *)   = null                                                                            
      * StringUtil.substring("", *)     = ""                                                                              
      * StringUtil.substring("abc", 0)  = "abc"                                                                           
      * StringUtil.substring("abc", 2)  = "c"                                                                             
      * StringUtil.substring("abc", 4)  = ""                                                                              
      * StringUtil.substring("abc", -2) = "bc"                                                                            
      * StringUtil.substring("abc", -4) = "abc"                                                                           
      * @author renjie
      * @param str �ַ���                                                                                                 
      * @param start ��ʼ���������Ϊ��������ʾ��β������                                                                 
      * @return �Ӵ������ԭʼ��Ϊ<code>null</code>���򷵻�<code>null</code>                                              
      */                                                                                                                  
     public static String substring(String str, int start) {                                                              
         if (str == null) {                                                                                               
             return null;                                                                                                 
         }                                                                                                                
                                                                                                                          
         if (start < 0) {     
        	 if((str.length()+start)>=0){
        		 start = str.length() + start;
        	 }else {
        		 return str;   
			}
         }                                                                                                                
                                                                                                                          
         if (start == 0) {                                                                                                 
             start = 0;                                                                                                   
         }                                                                                                                
                                                                                                                          
         if (start > str.length()) {                                                                                      
             return EMPTY_STRING;                                                                                         
         }                                                                                                                
                                                                                                                          
         return str.substring(start);                                                                                     
     }                                                                                                                    
                                                                                                                          
     /**                                                                                                                  
      * ȡָ���ַ������Ӵ�����ȡ�ַ�����
      * �������������β����ʼ���㡣����ַ���Ϊ<code>null</code>���򷵻�<code>null</code>��                                                                                                                                        
      * StringUtil.substring(null, *, *)    = null                                                                        
      * StringUtil.substring("", * ,  *)    = "";                                                                         
      * StringUtil.substring("abc", 0, 2)   = "ab"                                                                        
      * StringUtil.substring("abc", 2, 0)   = ""                                                                          
      * StringUtil.substring("abc", 2, 4)   = "c"                                                                         
      * StringUtil.substring("abc", 4, 6)   = ""                                                                          
      * StringUtil.substring("abc", 2, 2)   = ""                                                                          
      * StringUtil.substring("abc", -2, -1) = "b"                                                                         
      * StringUtil.substring("abc", -4, 2)  = "ab"                                                                        
      * @author renjie                                                                                                              
      * @param str �ַ���                                                                                                 
      * @param start ��ʼ���������Ϊ��������ʾ��β������                                                                 
      * @param end ���������������������Ϊ��������ʾ��β������                                                           
      * @return �Ӵ������ԭʼ��Ϊ<code>null</code>���򷵻�<code>null</code>                                              
      */                                                                                                                  
     public static String substring(String str, int start, int end) {                                                     
         if (str == null) {                                                                                               
             return null;                                                                                                 
         }                                                                                                                
                                                                                                                          
         if (end < 0) {                                                                                                   
             end = str.length() + end;                                                                                    
         }                                                                                                                
                                                                                                                          
         if (start < 0) {                                                                                                 
             start = str.length() + start;                                                                                
         }                                                                                                                
                                                                                                                          
         if (end > str.length()) {                                                                                        
             end = str.length();                                                                                          
         }                                                                                                                
                                                                                                                          
         if (start > end) {                                                                                               
             return EMPTY_STRING;                                                                                         
         }                                                                                                                
                                                                                                                          
         if (start == 0) {                                                                                                 
             start = 0;                                                                                                   
         }                                                                                                                
                                                                                                                          
         if (end == 0) {                                                                                                   
             end = 0;                                                                                                     
         }                                                                                                                
                                                                                                                          
         return str.substring(start, end);                                                                                
     }                                                                                                                    

    
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		Map reqMap = new HashMap();
//		reqMap.put(XmlData.ACCOUNTID, "02000000040507            ");
//		reqMap.put(XmlData.USERID, 123);
//		Map mediaItems = new HashMap();
//		mediaItems.put(XmlData.ACCOUNTID, "1     ");
//		mediaItems.put(XmlData.NAME, "hello1");
//		reqMap.put("mediaItems", mediaItems);
//		System.out.println(reqMap);
//		
//		reqMap = StringUtil.trimMap(reqMap);
//		System.out.println(reqMap);
		//0001259968
//		String str = "1259968";
		String str = "125";
		int len = -4; 
//		char fillChar = '0';
//		String position = STR_FRONT;
//		String resultStr = replenish(str, len, fillChar, position);
		String resultStr = substring(str, len);
		System.out.println(resultStr);
		
	}
}