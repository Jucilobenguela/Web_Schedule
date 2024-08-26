import { useEffect, useState } from "react";
import FundoUserAccess from "../../Imagem/fundo-userAccess.jpg"
import { Link } from "react-router-dom";
import styles from './Login.module.css'

function Login({ status }) {
    const [isVisivel, setIsVisivel] = useState(status);
    useEffect(() => {
        setIsVisivel(status);
    }, [status]);

    const enviar = ()=>{
        const email = document.querySelector("#email")
        fetch('https://api.exemplo.com/endpoint', {
            method: 'POST', 
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(dados) // Convertendo os dados para JSON
          })
            .then(response => {
              if (!response.ok) {
                throw new Error('Erro na requisição: ' + response.statusText);
              }
              return response.json();
            })
            .then(data => {
              console.log('Sucesso:', data); // Manipule a resposta aqui
            })
            .catch(error => {
              console.error('Erro:', error);
            });
    }
    return (
        <>
            {
                isVisivel && (
                        <div className={styles.formContainer}>
                            <h2>Login</h2>
                            <input id="email" className={styles.input} type="email" placeholder="Email Address" />
                            <input id="password" type="password" placeholder="Password" />
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