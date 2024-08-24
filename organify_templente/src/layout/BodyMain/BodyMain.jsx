import { useState } from 'react';
import styles from './BodyMain.module.css'
import CreateAccount from '../../componentes/CreateAccount/CreateAccount';
import Login from '../../componentes/Login/Login';
import { useContextValue } from '../../Hook/HookProvider.jsx';

function BodyMain() {
    const { showLogin, showCreate } = useContextValue()

    return (
        <section className={styles.sectionBodyMain}>
            <div className={styles.containerDescriction}>
                <h1>Bem-vindo ao Organify</h1>
                <p>Simplifique a gestão de agendamentos e otimize o atendimento ao cliente com *Organify*,
                    a aplicação web inovadora que conecta empresas e clientes de forma eficiente e sem complicações.
                    Com o Organify, empresas podem gerenciar seus agendamentos online de maneira prática e organizada,
                    enquanto os clientes têm a conveniência de marcar compromissos remotamente, sem precisar fazer uma ligação.

                </p>

            </div>
            {
                (showLogin || showCreate) && (
                    <div className={styles.containerUserAccess} >
                        <Login status={showLogin} />
                        <CreateAccount status={showCreate} />
                    </div>
                )
            }

        </section>

    )
}
export default BodyMain