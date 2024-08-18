import Login from "../componentes/Login"
import CreateAccount from "../componentes/CreateAccount"
import FundoUserAccess from "../Imagem/fundo-userAccess.jpg"
import { useState } from "react"

function UserAccess() {
   const [showCreate, setShowCreate]= useState(false);
   const [showLogin, setShowLogin]= useState(false);
   let handleCreate =()=>{
    setShowCreate(true)
    setShowLogin(false)
   } 
   let handleLogin =()=>{
    setShowCreate(false)
    setShowLogin(true)
   } 
    return (
        <>
            <main>
                <section className="container-userAccess">
                    <div>
                        <h2>Inicie Sua Aplicação</h2>
                    </div>
                    <img className="fundoUserAccess" src={FundoUserAccess} alt="" />
                    <div>
                    <div className="button-create">
                    <button onClick={handleCreate} className="button-create" type="button"> Create</button>
                    </div>
                    <div className="button-login">
                    <button onClick={handleLogin} className="button-login" type="button"> Login</button>
                       
                    </div>
                    </div>
                </section>
                { showCreate &&<CreateAccount/>}
                { showLogin && <Login/>}
               
            </main>
        </>

    )
}
export default UserAccess