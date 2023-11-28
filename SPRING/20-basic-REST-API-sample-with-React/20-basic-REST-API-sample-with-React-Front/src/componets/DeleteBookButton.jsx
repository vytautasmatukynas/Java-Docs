import React from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const DeleteBookButton = ({ bookId }) => {
    // UseNavigate hook from react-router-dom for navigation
    const navigate = useNavigate();

    // Function to handle book deletion
    const handleDelete = async () => {
        // Display a confirmation dialog
        const confirmDelete = window.confirm("Are you sure you want to delete this book?");
      
        // If the user confirms, proceed with deletion
        if (confirmDelete) {
          try {
            await axios.delete(`/books/delete/${bookId}`);
            console.log(`Book with ID ${bookId} deleted successfully`);
            // You can add additional logic if needed
          } catch (error) {
            console.error(`Error deleting book with ID ${bookId}:`, error);
          } finally {
            // After deleting, navigate back to the home page or perform other actions
            navigate("/");
          }
        }
      };

    // Button component for book deletion
    return <button onClick={handleDelete}>Delete</button>;
};

export default DeleteBookButton;
