package Readers;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    Properties properties=new Properties();
    FileReader fileReader;
    FileWriter fileWriter;
    String file;

    /**
     *
     * @return varsayılan DataFile/config.properties dosyasını okur
     */
    public static PropertyReader read(){
        return new PropertyReader("config");
    }

    public static PropertyReader read(String file){
        return new PropertyReader(file);
    }

    public String get(String key){
        return properties.getProperty(key);
    }

    public void  set(String key,String value){
        properties.setProperty(key,value);
    }


    private PropertyReader(String file){
        this.file="src/test/resources/DataFile/"+file+".properties";
        try (FileReader reader = fileReader = new FileReader(this.file)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
