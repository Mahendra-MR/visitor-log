import React, { useState } from 'react';
import axios from 'axios';

const VisitorForm = ({ onVisitorAdded }) => {
  const [visitor, setVisitor] = useState({
    name: '',
    phone: '',
    purpose: ''
  });

  const handleChange = (e) => {
    setVisitor({ ...visitor, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post('http://localhost:8080/api/visitors', visitor);
      onVisitorAdded(res.data); // Notify parent
      setVisitor({ name: '', phone: '', purpose: '' });
    } catch (err) {
      alert('Error adding visitor');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Visitor Check-In</h3>
      <input type="text" name="name" value={visitor.name} onChange={handleChange} placeholder="Name" required />
      <input type="text" name="phone" value={visitor.phone} onChange={handleChange} placeholder="Phone" required />
      <input type="text" name="purpose" value={visitor.purpose} onChange={handleChange} placeholder="Purpose" required />
      <button type="submit">Check In</button>
    </form>
  );
};

export default VisitorForm;
