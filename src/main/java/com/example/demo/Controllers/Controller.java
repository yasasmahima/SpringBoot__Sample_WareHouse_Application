package com.example.demo.Controllers;

import com.example.demo.Models.Checkouts;
import com.example.demo.Models.Item;
import com.example.demo.Models.Location;
import com.example.demo.View.ManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@Component
public class Controller implements ManagerInterface {

   ArrayList<Item> addedItems=new ArrayList();
   ArrayList<Checkouts> soldItems=new ArrayList<>();

   @Autowired
   Location location;

   @Autowired
   Item item;

   @Autowired
   Checkouts checkouts;


    static Scanner input=new Scanner(System.in);
    public Controller() {
        super();
    }

    @Override
    public void addItem() {
//        Item item=new Item();
        System.out.print("Input Id:");
        int id=input.nextInt();
        item.setId(id);

        System.out.print("Input Name : ");
        String name=input.next();
        item.setName(name);

        System.out.print("Input Seller : ");
        String seller=input.next();
        item.setSeller(seller);

//        Location location=new Location();
        System.out.print("Input shell No : ");
        int shellNO=input.nextInt();
        location.setShellNumber(shellNO);

        System.out.print("Input Bin No : ");
        int binNo=input.nextInt();
        location.setBinNumber(binNo);

        item.setLocation(location);
        addedItems.add(item);

    }

    @Override
    public void search(int id) {

        boolean availability=false;

        for (Item item:addedItems) {
            if(item.getId()==id){
                System.out.println(item);
                availability=true;
                break;
            }
        }

        if(!availability){
            System.out.println("This Item is not Available");
        }

    }

    @Override
    public void sell(int itemId) {

//        Item soldItem = null;

        boolean availability=false;
        for (Item itemCheck:addedItems) {
            if(item.getId()==itemId){
                availability=true;
                item=itemCheck;
                break;
            }
        }

        if(availability){

            checkouts.setSoldItem(item);

            System.out.print("Input Buyers Name : ");
            String buyersName=input.next();
            checkouts.setBuyersName(buyersName);

            LocalDate date=LocalDate.now();
            checkouts.setSelldate(date);

            addedItems.remove(item);
            soldItems.add(checkouts);

        }
    }

    @Override
    public void print() {
        System.out.println("====== Added Items  =======");

        for (Item item:addedItems) {
            System.out.println(item);
        }

        System.out.println("======== Sold Items ===========");

        for (Checkouts checkouts:soldItems) {
            System.out.println(checkouts);

        }
    }
}
