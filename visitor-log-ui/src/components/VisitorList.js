import React, { useEffect, useState } from 'react';
import axios from 'axios';

const VisitorList = () => {
  const [visitors, setVisitors] = useState([]);

  const fetchVisitors = async () => {
    try {
      const res = await axios.get('http://localhost:8080/api/visitors');
      setVisitors(res.data);
    } catch (err) {
      alert('Error fetching visitors');
    }
  };

  const handleCheckout = async (id) => {
    try {
      await axios.put(`http://localhost:8080/api/visitors/${id}/checkout`);
      fetchVisitors(); // Refresh list after checkout
    } catch (err) {
      alert('Checkout failed');
    }
  };

  const handleExport = () => {
    window.open("http://localhost:8080/api/export/visitors", "_blank");
  };

  useEffect(() => {
    fetchVisitors();
  }, []);

  return (
    <div>
      <h3>Visitor Log</h3>
      <button onClick={handleExport} style={{ marginBottom: '10px' }}>
        📤 Export CSV
      </button>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Purpose</th>
            <th>Check-in</th>
            <th>Check-out</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {visitors.map(v => (
            <tr key={v.id}>
              <td>{v.name}</td>
              <td>{v.phone}</td>
              <td>{v.purpose}</td>
              <td>{new Date(v.checkInTime).toLocaleString()}</td>
              <td>{v.checkOutTime ? new Date(v.checkOutTime).toLocaleString() : '—'}</td>
              <td>
                {!v.checkOutTime && (
                  <button onClick={() => handleCheckout(v.id)}>Check Out</button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default VisitorList;
