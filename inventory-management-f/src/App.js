import logo from './logo.svg';
import './App.css';
import MainForm from './components/MainForm';

function App() {
  return (
    <>
      <nav class="navbar bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
        <a class="navbar-brand" href="#">Inventory Management</a>

        </div>
      </nav>

      <MainForm/>
    </>
  );
}

export default App;
