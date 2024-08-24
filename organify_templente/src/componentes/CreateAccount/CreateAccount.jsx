import { useEffect, useState } from "react"
import FundoUserAccess from "../../Imagem/fundo-userAccess.jpg"
import styles from './CreateAccount.module.css'
function CreateAccount({ status }) {
    const [isVisivel, setIsVisivel] = useState(status);
    useEffect(() => {
        setIsVisivel(status);
    }, [status])
    return (
        <>
            {
                isVisivel && (
                        <div className={styles.formContainer}>
                            <h2>Signup</h2>
                            <input type="email" placeholder="Email Address" />
                            <input type="password" placeholder="Password" />
                            <input type="password" placeholder="Confirm password" />
                            <button className={styles.signupBtnPrimary}>Signup</button>
                        </div>
                )
            }
        </>
    )
}
export default CreateAccount