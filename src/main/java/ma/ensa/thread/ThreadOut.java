package ma.ensa.thread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.SneakyThrows;
import ma.ensa.dao.daoImpl.CostumerImpl;
import ma.ensa.dao.daoImpl.OrderImpl;
import ma.ensa.dto.OrderDto;
import ma.ensa.entity.Custumer;
import ma.ensa.entity.Order;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ThreadOut extends Thread{
    private Object mutex;
    private CostumerImpl costumerImpl;
    private OrderImpl orderImpl;
    public ThreadOut(Object mutex) throws SQLException, ClassNotFoundException {
        this.mutex = mutex;
        costumerImpl=new CostumerImpl();
        orderImpl=new OrderImpl();

    }
    @SneakyThrows
    public void run(){



        String s = "../input/";


        File file = new File(s);

        synchronized (mutex) {

            while (true) {



                File[] directory = file.listFiles();
                assert directory != null;
                for (File f : directory) {
                    if (f.getName().contains(".json")) {

                        System.out.println(f.getName());
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(f);
                        ArrayNode l = (ArrayNode) jsonNode.get("L");

                        Order order = new Order();
                        try {
                            List<OrderDto> orders=new ArrayList<OrderDto>();
                            for (JsonNode j : l) {
                            order.setId(j.get("id").asInt());
                            order.setAmount(j.get("amount").asDouble());
                            order.setCostumer(j.get("custumer").asInt());
                            order.setStatue(j.get("statue").asBoolean());
                            order.setDate(Date.valueOf(LocalDate.parse(j.get("date").asText())));
                            Custumer custumer=costumerImpl.getCostumer(order.getCostumer());
                            if (custumer==null){
                                throw new Exception();
                            }

                            OrderDto orderDto=new OrderDto();
                            orderDto.setAmount(order.getAmount());
                            orderDto.setOrderStatus(order.isStatue());
                            orderDto.setOrderId(order.getId());
                            orderDto.setCustomer(custumer);
                            orderDto.setOrderDate(order.getDate());
                            orders.add(orderDto);
                            orderImpl.addOrder(order);




                            }
                            String s1 = "../output/";
                            File f1 = new File(s1 + f.getName());
                            mapper.writeValue(f1,jsonNode);
                            System.out.println(mapper.writeValueAsString(orders));


                        } catch (Exception e) {
                            String s1 = "../erreur/";
                            File f1 = new File(s1 + f.getName());
                            f1.createNewFile();
                            mapper.writeValue(f1,jsonNode);
                            e.printStackTrace();


                        }


                        f.delete();
                        mutex.notify();
                        mutex.wait();



                    }
                }


            }
        }
    }
}
