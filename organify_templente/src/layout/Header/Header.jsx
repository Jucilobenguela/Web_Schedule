import { Link } from "react-router-dom"
import styles from './Header.module.css'
import { useContextValue } from "../../Hook/HookProvider"

function Header() {
    const {showFormCreate, showFormLogin } = useContextValue();
   
    const showLogin = () => {
        showFormLogin(true)

    }
    const showCreate =()=>{
        showFormCreate(true)
    }

    return (
        <>
            <nav className={styles.navBar}>
                <div className={styles.containerLogo}>
                    <h1>Organify</h1>
                </div>
                <div className={styles.containerMenu}>
                    <div className={styles.containerLink}>
                        <Link className={styles.link} to="/sobre">Sobre</Link>
                    </div>
                    <div className={styles.containerLink}>
                        <Link className={styles.link} to="/servico">Serviço</Link>
                    </div>
                    <div className={styles.containerLink}>
                        <Link className={styles.link} to="/contacto">Contacto</Link>
                    </div>
                </div>
                <div className={styles.buttonGroup}>
                    <button onClick={showLogin} className={styles.LoginBtn} >Login</button>
                    <button onClick={showCreate} className={styles.signupBtn}>Signup</button>
                </div>
            </nav>
        </>
    )
}
export default Header