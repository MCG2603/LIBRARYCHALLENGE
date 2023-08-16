package com.mcg.human;

import com.mcg.objects.Library;

public  class Person {
    private static int counter = 0;

    public String getName() {
        return name;
    }
    public int id() {
        return id;
    }

    String name;
    int id;
    public Person(String name){
        this.name=name;
        counter++;
        this.id=counter;
        Library.persons.put(counter,this);

    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Person)) {
            return false;
        }
        return ((Person) o).id()==this.id();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

