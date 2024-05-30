import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ListBHYT from './page/ListBHYT';
import ExportReport from './page/ExportReport';
import Configuration from './page/Configuration';

import Register from './page/Register';
import Login from './page/Login';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/listBHYT" exact element={<ListBHYT />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/exportReport" element={<ExportReport />} />
          <Route path="/configuration" element={<Configuration />} />
          <Route index element={<ListBHYT />} />
        </Routes>
      </Router>
      <ToastContainer
        position="top-right"
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
    />
    </div>

  );
}

export default App;
