import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from 'react-router-dom';
import axios from "axios";
import '../styles/UpdateBook.css';

const UpdateBookForm = () => {
    const navigate = useNavigate();
    const { id } = useParams();

    const [formData, setFormData] = useState({
        author: "",
        title: "",
        isbn: "",
        year: "",
    });

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchBookDetails = async () => {
            try {
                const response = await axios.get(`/books/get/${id}`);
                setFormData(response.data);
            } catch (error) {
                console.error(`Error fetching book details for ID ${id}:`, error);
            } finally {
                setLoading(false);
            }
        };

        fetchBookDetails();
    }, [id]);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const onUpdate = async (e) => {
        e.preventDefault();

        try {
            await axios.put(`http://127.0.0.1:8080/books/update/${id}`, formData);
            console.log(`Book with ID ${id} updated successfully`);
        } catch (error) {
            console.error(`Error updating book with ID ${id}:`, error);
        } finally {
            navigate("/");
        }
    };

    if (loading) {
        return;
    }

    return (
        <div className="update-book-container">
            {loading ? (
                <p>Loading...</p>
            ) : (
                <>
                    <h2>Update Book</h2>
                    <form onSubmit={onUpdate}>
                        <div className="form-container">
                            <div className="form-field">
                                <label>Author:</label>
                                <input
                                    type="text"
                                    name="author"
                                    value={formData.author}
                                    onChange={handleInputChange}
                                />
                            </div>
                            <div className="form-field">
                                <label>Title:</label>
                                <input
                                    type="text"
                                    name="title"
                                    value={formData.title}
                                    onChange={handleInputChange}
                                />
                            </div>
                            <div className="form-field">
                                <label>ISBN:</label>
                                <input
                                    type="text"
                                    name="isbn"
                                    value={formData.isbn}
                                    onChange={handleInputChange}
                                />
                            </div>
                            <div className="form-field">
                                <label>Year:</label>
                                <input
                                    type="text"
                                    name="year"
                                    value={formData.year}
                                    onChange={handleInputChange}
                                />
                            </div>
                            <button type="submit">Update</button>
                        </div>
                    </form>
                </>
            )}
        </div>
    );

};

export default UpdateBookForm;