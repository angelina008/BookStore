import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Categories from '../Categories/categories';
import Books from '../Books/BookList/books';
import Header from '../Header/header';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookService from "../../repository/BookStorepRepository";
import ProductEdit from "../Books/BookEdit/bookEdit";

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      books: [],
      categories: [],
      selectedBook: {}
    }
  }

  render() {
    return (
        <Router>
          <Header/>
          <main>
            <div className="container">
              <Route path={"/categories"} exact render={() =>
                  <Categories categories={this.state.categories}/>}/>
              <Route path={"/books/add"} exact render={() =>
                  <ProductAdd categories={this.state.categories}
                              onAddProduct={this.addBook}/>}/>
              <Route path={"/books/edit/:id"} exact render={() =>
                  <ProductEdit categories={this.state.categories}
                               onEditProduct={this.editBook}
                               book={this.state.selectedBook}/>}/>
              <Route path={"/books"} exact render={() =>
                  <Products products={this.state.books}
                            onDelete={this.deleteBook}
                            onEdit={this.getBook}/>}/>
              <Redirect to={"/books"}/>
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadCategories();
    this.loadProducts();
  }


  loadBooks = () => {
    BookService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

  loadCategories = () => {
    BookService.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

  deleteBook = (id) => {
    BookService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addBook = (name, author, category, quantity => {
    BookService.addBook(name, author,category, quantity)
        .then(() => {
          this.loadBooks();
        });
  })


  editBook = (id, name, author, category, quantity) => {
    EShopService.editProduct(id, name, price,  category, quantity)
        .then(() => {
          this.loadBooks();
        });
  }
}

export default App;
