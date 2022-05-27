package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        Student student = (Student) context.getBean("Student");
        student.doHomework();

        Phone phone = (Phone) context.getBean("Phone");
        System.out.println("Constructor Method:");
        System.out.println(phone);

        System.out.println();
        System.out.println("The setter method is also used with the XML I believe.");

/*        Address address = (Address) context.getBean("Address");
        System.out.println(address);*/

//        Vehicle obj = (Vehicle) context.getBean("Vehicle");
//        obj.drive();
    }
}
