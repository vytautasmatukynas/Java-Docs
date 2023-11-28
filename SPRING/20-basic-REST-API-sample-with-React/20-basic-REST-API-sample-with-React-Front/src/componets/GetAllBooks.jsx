import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "../styles/GetAllBooks.css";
import DeleteBookButton from "./DeleteBookButton";

const GetAllBooks = () => {
  // State to hold the book data and the ID of the selected book for updating
  const [data, setData] = useState([]);
  const [selectedBookId, setSelectedBookId] = useState(null);

  useEffect(() => {
    // Function to fetch book data and update the state
    const fetchData = async () => {
      try {
        const response = await axios.get("http://127.0.0.1:8080/books/getall");
        setData(response.data);
      } catch (error) {
        // Handle errors
        console.error('Error fetching data:', error.response.data.message);
      }
    };

    // Initial fetch and set up interval for periodic updates
    fetchData();
    const intervalId = setInterval(fetchData, 5000);

    // Cleanup function to clear the interval when the component unmounts
    return () => clearInterval(intervalId);
  }, []); // Dependency array is empty to run the effect only on mount and unmount

  // Function to handle book deletion
  const handleDelete = async (deletedBookId) => {
    try {
      await axios.delete(`/books/delete/${deletedBookId}`);
      setData((prevData) => prevData.filter((item) => item.id !== deletedBookId));
    } catch (error) {
      // Handle errors
      console.error(`Error deleting book with ID ${deletedBookId}:`, error.response.data.message);
    }
  };

  return (
    <div>
      <h1 className="table-header">Books Table</h1>

      <br />

      {/* Link to the "Add" page */}
      <div className="add-button-container">
        <Link to="/add">
          <button className="add-button">Add Book</button>
        </Link>
      </div>

      <br />

      <div className="table-container">
        {data.length === 0 ? (
          <p>Loading...</p>
        ) : (
          <table className="styled-table">
            <thead>
              <tr>
                <th>Author</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Year</th>
                <th className="table-buttons">Action</th>
                <th className="table-buttons">Action</th> {/* New column for Update buttons */}
              </tr>
            </thead>
            <tbody>
              {data.map((item) => (
                <tr key={item.id}>
                  <td>{item.author}</td>
                  <td>{item.title}</td>
                  <td>{item.isbn}</td>
                  <td className={item.year === Number(new Date().getFullYear()) ? "blue-cell" : ""}>
                    {item.year}
                  </td>
                  <td className="table-buttons"><DeleteBookButton bookId={item.id} onDelete={handleDelete} /></td>
                  <td className="table-buttons">
                    <Link to={`/update/${item.id}`}>
                      <button onClick={() => setSelectedBookId(item.id)}>Update</button>
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default GetAllBooks;
