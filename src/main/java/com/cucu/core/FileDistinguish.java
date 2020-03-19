package com.cucu.core;

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.log4j.Logger;
import org.ini4j.Wini;

public class FileDistinguish
{
    Wini ini;
    public static String filename;
    // private static Logger logger = Logger.getLogger(FileDistinguish.class);

    public FileDistinguish(String f)
    {
        filename = f;
    }

//    public List<String> get_login_number(String sector)
//    {
//        List<String> list = new ArrayList();
//        try
//        {
//            this.ini = new Wini(new File(filename));
//            list.add(this.ini.get("url", "url"));
//            list.add(this.ini.get(sector, "number"));
//            list.add(this.ini.get(sector, "manager_name"));
//            list.add(this.ini.get(sector, "manager_pwd"));
//            return list;
//        }
//        catch (IOException e)
//        {
//            logger.error(filename + " is not exist", e);
//            e.printStackTrace();
//        }
//        return list;
//    }

    public String get_Sector_OptionValue(String sectionName, String optionName)
    {
        try
        {
            this.ini = new Wini(new File(filename));
            return this.ini.get(sectionName, optionName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
