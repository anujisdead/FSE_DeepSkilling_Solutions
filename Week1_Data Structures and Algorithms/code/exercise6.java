package code;
class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}

class BookSearch {
    static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) return book;
        }
        return null;
    }

    static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareTo(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}

class BookSearchTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "A Tale of Two Cities", "Charles Dickens"),
            new Book(2, "Moby Dick", "Herman Melville"),
            new Book(3, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(4, "To Kill a Mockingbird", "Harper Lee")
        };
        // Array must be sorted by title for binary search
        java.util.Arrays.sort(books, (a, b) -> a.title.compareTo(b.title));

        System.out.println("Linear Search for 'Moby Dick':");
        Book foundBookLinear = BookSearch.linearSearch(books, "Moby Dick");
        if(foundBookLinear != null) {
            System.out.println("Found: " + foundBookLinear.title);
        } else {
            System.out.println("Not found.");
        }

        System.out.println("\nBinary Search for 'The Catcher in the Rye':");
        Book foundBookBinary = BookSearch.binarySearch(books, "The Catcher in the Rye");
        if(foundBookBinary != null) {
            System.out.println("Found: " + foundBookBinary.title);
        } else {
            System.out.println("Not found.");
        }
    }
}
