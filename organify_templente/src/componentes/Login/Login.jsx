import { useEffect, useState } from "react";
import FundoUserAccess from "../../Imagem/fundo-userAccess.jpg"
import { Link } from "react-router-dom";
import styles from './Login.module.css'

function Login({ status }) {
    const [isVisivel, setIsVisivel] = useState(status);
    useEffect(() => {
        setIsVisivel(status);
    }, [status])
    return (
        <>
            {
                isVisivel && (
                        <div className={styles.formContainer}>
                            <h2>Login</h2>
                            <input className={styles.input} type="email" placeholder="Email Address" />
                            <input type="password" placeholder="Password" />
                            <a href="#" className={styles.forgotPassword}>Forgot password?</a>
                            <button className={styles.loginBtnPrimary}>
                                <Link className={styles.loginBtnPrimary} to="/management"> < label htmlFor="button-go">
                                    Login</label>
                                </Link>
                            </button>
                            <div className={styles.signupLink}>
                                Not a member? <a href="#">Signup now</a>
                            </div>
                        </div>
                    
                )
            }
        </>

    )
}
export default Login