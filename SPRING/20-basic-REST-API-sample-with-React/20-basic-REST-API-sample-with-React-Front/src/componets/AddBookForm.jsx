import React, { useState } from "react";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import '../styles/AddBook.css';

const AddBookForm = () => {
    const navigate = useNavigate();

    // State to manage form data
    const [formData, setFormData] = useState({
        author: "",
        title: "",
        isbn: "",
        year: "",
    });

    // State to manage the list of books
    const [books, setBooks] = useState([]);

    // Function to handle input changes
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    // Function to handle add button click
    const handleAddClick = async (e) => {
        e.preventDefault();
      
        try {
          const response = await axios.post('/books/add', formData);
          console.log('Add successful:', response.data);
          // Update the list of books with the new book
          setBooks((prevBooks) => [...prevBooks, response.data]);
          // Clear form data after successful add
          setFormData({
            author: "",
            title: "",
            isbn: "",
            year: "",
          });
        } catch (error) {
          // Check if error.response exists
          if (error.response) {
            // Handle HTTP error response
            console.error("Error adding book:", error.response.data.message);
          } else {
            // Handle other types of errors (e.g., network error)
            console.error("Error adding book:", error.message);
          }
        } finally {
          // After adding, navigate back to the home page or perform other actions
          navigate("/");
        }
      };
      

    return (
        <div className="add-book-container">
            <h2>Add a New Book</h2>
            <form onSubmit={handleAddClick}>
                <div className="form-container">
                    <div className="form-field">
                        <label>Author:</label>
                        <input type="text"
                            name="author"
                            value={formData.author}
                            onChange={handleInputChange} />
                    </div>
                    <div className="form-field">
                        <label>Title:</label>
                        <input type="text"
                            name="title"
                            value={formData.title}
                            onChange={handleInputChange} />
                    </div>
                    <div className="form-field">
                        <label>ISBN:</label>
                        <input type="text"
                            name="isbn"
                            value={formData.isbn}
                            onChange={handleInputChange} />
                    </div>
                    <div className="form-field">
                        <label>Year:</label>
                        <input type="text"
                            name="year"
                            value={formData.year}
                            onChange={handleInputChange} />
                    </div>
                    <button type="submit">Add</button>
                </div>
            </form>
        </div>
    );
};

export default AddBookForm;
