import { useEffect, useState } from "react";
import FundoUserAccess from "../../Imagem/fundo-userAccess.jpg"
import { Link } from "react-router-dom";
import Management from "../../pages/Menagement";

function Login({status}) {
    const[isVisivel, setIsVisivel]=useState(status);
    useEffect(()=>{
        setIsVisivel(status);
    }, [status])
    return (
        <>
        {
            isVisivel && (
                <section className="login-container">
                <form>
                    <h2>Inicie Sua Conta</h2>
                    <div>
                        <img className="fundoUserAccess" src={FundoUserAccess} alt="" />
                    </div>
                    <div>
                        <div className="form-group-login">
                            <label htmlFor="emailLogin">Email:</label>
                            <input id="emailLogin" name="email" type="email" />
                        </div>
                        <div className="form-group-login">
                            <label htmlFor="passwordLogin">Password:</label>
                            <input id="passwordLogin" type="password" name="password" />
                        </div>
                        <div className="form-group-login">
                            <input type="button" id="button-go" />
                                <Link to="/management"> < label htmlFor="button-go">
                                GO!</label></Link>
                                           
                        </div>
                    </div>
                </form>
            </section>
            )
        }
        </>
       
    )
}
export default Login