import FundoUserAccess from "../Imagem/fundo-userAccess.jpg"
function CreateAccount(){
    return(
        <section className="registration-container">
        <h2>Registrar-se</h2>
        <div>
                    <img className="fundoUserAccess" src={FundoUserAccess} alt="" />
                </div>
        <form action="/submit-registration" method="post">
            <div className="form-group-registration">
                <label htmlFor="name">Nome:</label>
                <input type="text" id="name" name="name" required/>
            </div>
            <div className="form-group-registration">
                <label htmlFor="email">Email:</label>
                <input type="email" id="email" name="email" required/>
            </div>
            <div className="form-group-registration">
                <label htmlFor="password">Senha:</label>
                <input type="password" id="password" name="password" required/>
            </div>
            <div className="form-group-registration">
                <button type="submit">Registrar</button>
            </div>
        </form>
    </section>
    )
}
export default CreateAccount