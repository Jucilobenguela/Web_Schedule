import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Management from "./pages/Menagement";
import About from "./pages/About";

function AppRoutes(){
    
return(
    <BrowserRouter>
    <Routes>
        <Route path="/" element={ <Home/> }/>
        <Route path="/management" element={<Management/>}/>
        <Route path="/sobre" element={<About/>}/>
    </Routes>
    </BrowserRouter>
)
}
export default AppRoutes