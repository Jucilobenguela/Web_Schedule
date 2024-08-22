import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Management from "./pages/Menagement";

function AppRoutes(){
    
return(
    <BrowserRouter>
    <Routes>
        <Route path="/" element={ <Home/> }></Route>
        <Route path="/management" element={<Management/>}></Route>
    </Routes>
    </BrowserRouter>
)
}
export default AppRoutes