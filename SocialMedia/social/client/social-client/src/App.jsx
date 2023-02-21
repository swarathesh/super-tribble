import { BrowserRouter, Navigate, Routes, Route } from "react-router-dom";
import { useMemo } from "react";
import { useSelector } from "react-redux";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { createTheme } from "@mui/material/styles";
import LoginPage from "./scenes/loginPage";

function App() {
  return (
    <div className="app"> 
      <BrowserRouter>
       <CssBaseline />
        <Routes>  
          <Route path="/" element={<LoginPage />} />

       </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
