import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import GetAllBooks from "./GetAllBooks";
import AddBookForm from "./AddBookForm";
import UpdateBookForm from "./UpdateBookForm";

const App = () => {
  // Define routes using the Routes and Route components from react-router-dom
  return (
    <Router>
      <div>
        <Routes>
          {/* Route for the home page */}
          <Route path="/" element={<GetAllBooks />} />
          {/* Route for adding a new book */}
          <Route path="/add" element={<AddBookForm />} />
          {/* Route for updating a book, with a dynamic parameter ':id' */}
          <Route path="/update/:id" element={<UpdateBookForm />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
