package Readers;

import Pojo.BasePojo;
import Pojo.Saucedemo_Info;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {

    private String fileName="";
    private FileReader reader;
    private Gson gson;


    public static JsonReader read() {
        return new JsonReader("config");
    }

    public static JsonReader read(String fileName) {
        return new JsonReader(fileName);
    }

    public BasePojo getPojo(BasePojo pojo) {
        gson = new Gson();
        return gson.fromJson(reader, pojo.getClass());
    }


    private JsonReader(String fileName) {
        fileName="src/test/resources/DataFile/config.json";

        System.out.println(fileName);

        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void Tesst1() throws FileNotFoundException {

        BasePojo config = JsonReader.read("config").getPojo(new BasePojo());
        Saucedemo_Info config1 = (Saucedemo_Info) config;
        System.out.println(config1.getLogin().getPassword());

    }

}
