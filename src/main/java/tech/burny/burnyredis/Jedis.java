package tech.burny.burnyredis;

import io.netty.util.internal.StringUtil;
import org.springframework.util.StringUtils;

/**
 * @Note TODO
 * @Author cyx
 * @Date 2022/9/14 23:39
 */

public class Jedis {

    public static void main(String[] args) {
        //redis.clients.jedis.Jedis jedis=new redis.clients.jedis.Jedis("192.168.1.236",6379);
        //jedis.ping();

            StringBuffer sb = new StringBuffer();
            sb.append("DECLARE \n" +
                    "num number(10);\n" +
                    "ddl_sql VARCHAR2(500);\n" +
                    "del_sql varchar2(500);\n" +
                    "begin \n" +
                    "ddl_sql := 'CREATE TABLE "+"database"+"."+"datatable"+"(\n" +
                    "table_schema varchar(255),\n" +
                    "table_name varchar(255),\n" +
                    "field_name LONGTEXT,\n" +
                    "field_content_new LONGTEXT ,\n" +
                    "cud varchar(255),\n" +
                    "field_content_old LONGTEXT,\n" +
                    "create_at DATE  NOT NULL DEFAULT SYSDATE  \n" +
                    ") ';\n" +
                    "del_sql := 'drop table BPMS_RU_XXX_ALL_TMP ';\n" +
                    "     select count(1) into num from user_tables where table_name = upper('BPMS_RU_XXX_ALL_TMP') ;\n" +
                    "if num = 0 then\n" +
                    " EXECUTE  IMMEDIATE  ddl_sql;\n" +
                    " end if;\n" +
                    "end;");
        System.out.println(sb.toString());



    }
}
