// powered by 天津理工大学心理辅导团队

package io.renren.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Exception工具类
 *
 * @author Tjut team
 */
public class ExceptionUtils {

    /**
     * 获取异常信息
     * @param ex  异常
     * @return    返回异常信息
     */
    public static String getErrorStackTrace(Exception ex){
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw, true);
            ex.printStackTrace(pw);
        }finally {
            try {
                if(pw != null) {
                    pw.close();
                }
            } catch (Exception e) {

            }
            try {
                if(sw != null) {
                    sw.close();
                }
            } catch (IOException e) {

            }
        }

        return sw.toString();
    }
}