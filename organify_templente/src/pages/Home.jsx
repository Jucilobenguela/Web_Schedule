import Header from "../layout/Header"
import UserAccess from "../Layout/UserAccess"
import fundo from "../Imagem/agenda_home.webp"
import Management from "./Menagement"

function Home(){
    return(
        <div className="container-home">
     
      {/*<Header/>
       <UserAccess/>*/}
       <Management></Management>
        </div>
      
    )
}
export default Home