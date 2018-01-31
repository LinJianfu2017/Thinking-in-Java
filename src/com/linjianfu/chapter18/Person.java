package com.linjianfu.chapter18;

import nu.xom.Document;
import nu.xom.Element;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class Person {

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("A1", "B1", "1501-1"),
                new Person("A2", "B2", "1501-2"),
                new Person("A3", "B3", "1501-3")
        );
        System.out.println(people);
        Element root = new Element("people");
        for (Person p : people)
            root.appendChild(p.getXML());
        Document doc = new Document(root);
        Eighteen32.format(System.out, doc);
        Eighteen32.format(new BufferedOutputStream(
                new FileOutputStream("People31.xml")), doc);
    }

    private String first, last, address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        Element lastName = new Element("last");
        Element homeAddress = new Element("address");
        firstName.appendChild(first);
        lastName.appendChild(last);
        homeAddress.appendChild(address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(homeAddress);
        return person;
    }

    //Constructor to restore(recover) a Person from an XML Element.-->People.java uses
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last + " " + address;
    }
}
