package com.mcg.human;
import com.mcg.objects.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Person {

    public List<Book> books;

    public Author(String name) {
        super(name);

    }



    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Author)) {
            return false;
        }
        return ((Author) o).id()==this.id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
