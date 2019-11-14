package com.drnmnl.devtests.streams;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class StreamSample {
    private List<Person> personList;

    {
        personList = new ArrayList<>(Arrays.asList(
                new Person("Darren", 26),
                new Person("X", 29),
                new Person("Y", 35)
        ));
    }

    public void demoLambda() {
        List<Person> personListCopy = new ArrayList<>(personList);
        // Sample Lambda Expressions with Stream
        // filter: filters by age 1-30
        // map: map Person elements into Person.name elements
        // forEach: calls SysOut for each element

        personListCopy.stream()
                .filter(p -> p.getAge() >=1 && p.getAge() <=30)
                .map(p->p.getName())
                .forEach(p-> System.out.println(""));

        // Output: Darren X

        personListCopy = new ArrayList<>(personList);
        personListCopy.stream()
                .filter(p -> p.getAge() >=1 && p.getAge() <=30)
                .peek(p-> System.out.println(p.getAge()))
                .map(p->p.getName())
                .forEach(p-> System.out.println(p));

        // Output: Prints age before name for each iteration

        Comparator<Person> comparator = Comparator.comparing(p -> p.getAge());

    }

    public void demoStoredLambda(){

    }
}
