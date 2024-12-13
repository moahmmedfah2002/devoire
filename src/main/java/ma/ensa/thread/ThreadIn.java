package ma.ensa.thread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Random;

@Data
public class ThreadIn extends Thread{
    private Object mutex=new Object();
    public ThreadIn(Object mutex){
        this.mutex=mutex;

    }

    @Override
    public synchronized void run() {


            while (true) {
                synchronized(mutex) {
                String s = null;
                try {


                    s = "../input/";
                    File file = new File(s + System.currentTimeMillis() + ".json");
//                    File file = new File("input/"+System.currentTimeMillis() + ".json");
                    if (file.createNewFile()) {
//                        FileReader actualFile = new FileReader(file);
//                        actualFile.close();
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode root = mapper.readTree(file);
                        ObjectNode obj = mapper.createObjectNode();
                        ObjectNode obj2 = mapper.createObjectNode();

                        obj2.put("id", new Random().nextInt());
                        obj2.put("date", String.valueOf(LocalDate.now()));
                        obj2.put("amount", new Random().nextDouble());
                        obj2.put("custumer", 1);
                        obj2.put("statue", new Random().nextBoolean());


                        obj.path(s + System.currentTimeMillis() + ".json");

                        ArrayNode li = obj.putArray("L");
                        li.add(obj2);
                        li.add(obj2);


                        mapper.writeValue(file, obj);




                    } else {
                        System.out.println("File already exists.");

                    }

                } catch (  IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    sleep(10000);


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                    mutex.notify();
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
        }
    }


}
