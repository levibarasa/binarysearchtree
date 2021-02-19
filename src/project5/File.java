/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class File {
    Properties prop;

    public File() {
    }
    public Properties getDBProperty() {
        prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream url = classLoader.getResourceAsStream("Data.properties");
            prop.load(url);
        } catch (IOException asd) {
            System.out.println(asd.getMessage());
        }
        return prop;
    }
}
