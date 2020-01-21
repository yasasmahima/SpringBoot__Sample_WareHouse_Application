package com.example.demo;

import com.example.demo.Controllers.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sun.reflect.generics.scope.Scope;

import java.awt.*;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(DemoApplication.class, args);
//        SpringApplication.run(DemoApplication.class, args);
        Controller controller=context.getBean(Controller.class);
        System.out.println("============= Welcome To Ware Hose ==================");
        int option=0;

        while (option!=5){
            option=getOption();

            switch (option){
                case 1:
                    controller.addItem();
                    break;
                case 2:
                    System.out.print("Input Item Id to search  : ");
                    int id=input.nextInt();
                    controller.search(id);
                    break;
                case 3:
                    System.out.print("Input Item Id to Sell  : ");
                    int idSearch=input.nextInt();
                    controller.sell(idSearch);
                    break;
                case 4:
                    controller.print();
                    break;
            }
        }

        System.out.println("================ END ======================");

    }

    //Printing Console Menu
    public static int getOption(){
        System.out.println("Select Your Option \n" +
                "01) Add Item \n" +
                "02) Search Item\n" +
                "03) Sell Item\n" +
                "04) View Report \n" +
                "05) Exit"

        );

        System.out.print("Input Your Option\t:\t");
        exceptionHandling();               //calling exception handling method
        int option=input.nextInt();        //Get Option again when user input an invalid option
        option = invalidOption(option);
        System.out.println("---------------------------");

        return option;
    }

    //Exception handling (TypeMisMatch Exception)
    public static void exceptionHandling() {
        String message="You have entered an Invalid option\n" +
                "Input Your Option\t:\t";
        while (!input.hasNextInt()) {
            System.out.print(message);
            input.next();
        }
    }

    //Check Valid Option ( Check Range )
    public static int invalidOption(int option) {
        while (!(1 <= option && option <= 5)) {
            System.out.print("You have entered an Invalid option\n" +
                    "Input Your Option\t:\t");
            exceptionHandling();
            option = input.nextInt();
        }
        return option;
    }

}
