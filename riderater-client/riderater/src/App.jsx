import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Locations from './components/Locations';
import './App.css'

function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/locations" element={<Locations/>}/>
          </Routes>
      </Router>

  )
}

export default App
