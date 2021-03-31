import axios from '../custom-axios/axios';

const BookService = {
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, author, category, quantity) => {
        return axios.post("/books/add", {
            "name" : name,
            "author" : author,
            "category" : category,
            "quantity" : quantity
        });
    },
    editBook: (id, name, author, category,quantity) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "author" : author,
            "category" : category,
            "quantity" : quantity
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }
}

export default BookService;
