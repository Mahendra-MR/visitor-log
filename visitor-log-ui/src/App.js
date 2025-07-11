import React from 'react';
import VisitorForm from './components/VisitorForm';
import VisitorList from './components/VisitorList';

function App() {
  return (
    <div className="App" style={{ padding: 20 }}>
      <h2>Smart Visitor Log System</h2>
      <VisitorForm onVisitorAdded={() => window.location.reload()} />
      <hr />
      <VisitorList />
    </div>
  );
}

export default App;
