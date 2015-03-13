/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Address;
import entity.Person;
import facade.EntityFacade;
import javax.persistence.Persistence;
import rest.PersonDTO;

public class Tester {

    public static void main(String[] args) {
        EntityFacade facade = new EntityFacade(Persistence.createEntityManagerFactory("CA2WebPU"));
        PersonDTO p = new PersonDTO("andersand@live.dk","anders","and","rolighedsvej","cover","1300");
       
     
        Person p2 = facade.createPerson2(p);

        System.out.println(p2.getId());
       
        PersonDTO p4 = new PersonDTO("Bang@live.dk","Lasse","Bang","bangerup","bang&olufsen","2400");
        
        Person p5 = facade.createPerson2(p4);

        System.out.println(p5.getId());
//
//        Hobby h1 = new Hobby("Tennis", "Smashing a ball");
//        p = facade.addHobby(p, h1);
//
//        System.out.println(p.getHobbies().get(0).getName());
//
//        Hobby h2 = new Hobby("Gaming", "Going crazy");
//        p = facade.addHobbyFromId(1, h2);
//
//        System.out.println(p.getHobbies().get(1).getName());
//
//        Person person = facade.findPerson(1);        
//        System.out.println(person.getFirstName());
//        
//        
//        
//        
//        List<Person> persons = facade.getPersons();
//        System.out.println(persons.size());
//        System.out.println(persons.get(0).getFirstName());
//        System.out.println(persons.get(0).getLastName());
//        
//   
//
    }

}
