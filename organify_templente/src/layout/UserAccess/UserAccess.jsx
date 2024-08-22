import Login from "../../componentes/Login/Login"
import styles from './UserAccess.module.css'
import CreateAccount from "../../componentes/CreateAccount/CreateAccount"
import FundoUserAccess from "../../Imagem/fundo-userAccess.jpg"
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
            <main  className={styles.containerMain}>
                <section className={styles.containerUserAccess}>
                    <div>
                        <h2>Inicie Sua Aplicação</h2>
                    </div>
                    <img className={styles.fundoUserAccess} src={FundoUserAccess} alt="" />
                    <div>
                    <div className={styles.containerButtonCreate}>
                    <button onClick={handleCreate} className={styles.buttonCreate} type="button"> Create</button>
                    </div>
                    <div className={styles.containerButtonLogin}>
                    <button onClick={handleLogin} className={styles.buttonLogin} type="button"> Login</button>
                       
                    </div>
                    </div>
                </section>
                <CreateAccount status={showCreate}/>
                 <Login status={showLogin}/>
               
            </main>
        </>

    )
}
export default UserAccess