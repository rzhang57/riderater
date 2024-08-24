import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Locations from './components/Locations';
import './App.css'
import AttractionList from "./components/AttractionList";
import RatingsList from "./components/RatingsList.jsx";
import '@radix-ui/themes/styles.css';


export default function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/locations" element={<Locations/>}/>
              <Route path="/locations/:location" element={<AttractionList/>}/>
              <Route path="/locations/:location/attraction/:attractionId" element={<RatingsList/>}/>
          </Routes>
      </Router>
)
}
