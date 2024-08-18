import Header from "../layout/Header"
import UserAccess from "../Layout/UserAccess"
import fundo from "../Imagem/agenda_home.webp"

function Home(){
    return(
        <div className="container-home">
       <Header/>
       <UserAccess/>
        </div>
      
    )
}
export default Home