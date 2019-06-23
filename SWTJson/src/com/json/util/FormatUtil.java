package com.json.util;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

//格式化String  
public class FormatUtil {
    /**
     * 格式化
     * 
     * @param jsonStr
     * @return
     * @author lizhgb
     * @Date 2015-10-14 下午1:17:35
     * @Modified 2017-04-28 下午8:55:35
     */
	
	/*
	 * public static void main(String[] args) {
	 * formatJson("{\"@xmlns\":\"http://maven.apache.org/POM/4.0.0\",\"@xmlns:xsi\":\"http://www.w3.org/2001/XMLSchema-instance\",\"@xsi:schemaLocation\":\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\",\"modelVersion\":\"4.0.0\",\"groupId\":\"com.freesoft.mvn-webapp\",\"artifactId\":\"mvnwebapp\",\"packaging\":\"war\",\"version\":\"1.0-SNAPSHOT\",\"name\":\"mvnwebapp Maven Webapp\",\"url\":\"http://maven.apache.org\",\"dependencies\":{\"dependency\":{\"groupId\":\"junit\",\"artifactId\":\"junit\",\"version\":\"4.11\",\"scope\":\"test\"}},\"build\":{\"finalName\":\"mvnwebapp\",\"pluginManagement\":{\"plugins\":{\"plugin\":{\"groupId\":\"org.apache.tomcat.maven\",\"artifactId\":\"tomcat7-maven-plugin\",\"version\":\"2.1\",\"configuration\":{\"tomcat-url\":\"http://localhost:8080/manager/html\",\"server\":\"tomcat_localtest\"}}}}},\"properties\":{\"struts.version\":\"2.3.15\",\"mysql.version\":\"5.1.29\",\"hibernate.version\":\"4.3.1.Final\"}}"
	 * ); }
	 */
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr))
            return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
            case '"':
                                if (last != '\\'){
                    isInQuotationMarks = !isInQuotationMarks;
                                }
                sb.append(current);
                break;
            case '{':
            case '[':
                sb.append(current);
                if (!isInQuotationMarks) {
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                }
                break;
            case '}':
            case ']':
                if (!isInQuotationMarks) {
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                }
                sb.append(current);
                break;
            case ',':
                sb.append(current);
                if (last != '\\' && !isInQuotationMarks) {
                    sb.append('\n');
                    addIndentBlank(sb, indent);
                }
                break;
            default:
                sb.append(current);
            }
        }
        
        return sb.toString();
    }

    /**
     * 添加space
     * 
     * @param sb
     * @param indent
     * @author lizhgb
     * @Date 2015-10-14 上午10:38:04
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
    
    public static void ifgetJson(String reqjson) throws Exception{
        try {
            JSONObject jsonObject = JSONObject.fromObject(reqjson);
        } catch (JSONException e) {
          

        }
    }
}
