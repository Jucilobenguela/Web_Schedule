import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import styles from './SectionEmpregados.module.css'
import { faPlus } from '@fortawesome/free-solid-svg-icons'
import AddEmpregados from '../AddEmpregados/AddEmpregados'
import { useEffect, useState } from 'react'

function SectionEmpregados({status }) {
    const [isVisivelForm, setIsVisivelForm] = useState(status)
    

    const [isVisivel, setIsVisivel] = useState(false);
    useEffect(()=>{
        setIsVisivelForm(status);
    }, [status]);
    const showAddEmpregados = () => {
        setIsVisivel(true)
    }
    const hideAddEmpregados = () => {
        setIsVisivel(false)
    }
    console.log(isVisivelForm)
    return (
        <>{isVisivelForm && (

            <section>
                <div className={styles.containerEmpregados}>
                    <div className={styles.empregadosList} id="employeeList">
                        <h3>Funcionários</h3>
                        <div className={styles.containerFindEmpregados}>
                            <input type="text" id="searchInput" placeholder="Buscar por nome" />
                            <button>Buscar</button>
                        </div>
                        <div className={styles.containerShowEmpregados}>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Nome do Funcionário</th>
                                        <th>Categoria do Atendimento</th>
                                        <th>Serviço</th>
                                        <th>Dia de Folga</th>
                                        <th>Horário de Trabalho</th>
                                        <th>Horário de Almoço</th>
                                        <th>Clientes com Reserva</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>João Silva</td>
                                        <td>Masculino</td>
                                        <td>Corte</td>
                                        <td>Segunda</td>
                                        <td>09:00 - 18:00</td>
                                        <td>10</td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div className={styles.containerIconPlus}>
                        <FontAwesomeIcon onClick={showAddEmpregados} className={styles.IconPlus} icon={faPlus} />
                    </div>

                </div>
                <div className='test'>
                    {isVisivel && (<AddEmpregados func={hideAddEmpregados} status={isVisivel} />)}
                </div>
            </section>

        )}</>)
}
export default SectionEmpregados

