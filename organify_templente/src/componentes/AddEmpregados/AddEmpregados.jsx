import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import styles from './AddEmpregados.module.css'
import { faTimes } from '@fortawesome/free-solid-svg-icons'
import { useRef, useState } from 'react'


function AddEmpregados({func, status}) {
    const [hide, setHide] = useState(status);
    const employerList= fetch('http://localhost:8080/employer')
  .then(response => {
    if (!response.ok) {
      throw new Error('Erro na requisição: ' + response.statusText);
    }
    return response.json();
  })
  .then(data => {
    console.log(data);
  })
  .catch(error => {
    console.error('Erro:', error);
  });
  console.log(employerList)
   
    return (
        <>
            {hide && (
                <section className='section-add-empregados'>
                    <div className={styles.containerAddEmpregados}>
                        <form className={styles.formAddEmpregados}>

                            <div className={styles.containerIconExit}>
                                <FontAwesomeIcon onClick={func} className={styles.iconExit} icon={faTimes} />
                            </div>

                            <div className={styles.cantainer}>
                                <label htmlFor="nome">Nome:</label>
                                <input type="text" id="nome" name="nome" required />
                            </div>
                            <div className={styles.cantainer}>
                                <label htmlFor="password">Senha:</label>
                                <input type="password" id="password" name="password" required />
                            </div>

                            <div className={styles.cantainer}>
                                <label htmlFor="tipo_atendimento">Tipo de Atendimento:</label>
                                <select id="tipo_atendimento" name="tipo_atendimento" required>
                                    <option value="masculino">Masculino</option>
                                    <option value="feminino">Feminino</option>
                                    <option value="ambos">Masculino e Feminino</option>
                                </select>
                            </div>

                            <div className={styles.cantainer}>
                                <label htmlFor="servicos">Serviços:</label>
                                <select id="servicos" name="servicos[]" required>
                                    <option value="corte">Corte de Cabelo</option>
                                    <option value="barba">Barba</option>
                                    <option value="madeixas">Madeixas</option>
                                    <option value="coloracao">Coloração</option>
                                </select>
                            </div>

                            <div className={styles.cantainer}>
                                <label htmlFor="dia_nao_trabalha">Dia que não trabalha:</label>
                                <select id="dia_nao_trabalha" name="dia_nao_trabalha" required>
                                    <option value="domingo">Domingo</option>
                                    <option value="segunda">Segunda-feira</option>
                                    <option value="terca">Terça-feira</option>
                                    <option value="quarta">Quarta-feira</option>
                                    <option value="quinta">Quinta-feira</option>
                                    <option value="sexta">Sexta-feira</option>
                                    <option value="sabado">Sábado</option>
                                </select>
                            </div>

                            <div className={styles.cantainer}>
                                <h5>Período de Férias</h5>
                                <div>
                                    <label htmlFor="ferias_inicio">Início:</label>
                                    <input type="date" id="ferias_inicio" name="ferias_inicio" required />
                                </div>
                                <div>
                                    <label htmlFor="ferias_fim">Fim:</label>
                                    <input type="date" id="ferias_fim" name="ferias_fim" required />
                                </div>
                            </div>

                            <div className={styles.cantainer}>
                                <h5>Periodo do Trabalho</h5>
                                <div>
                                    <label htmlFor="horario_inicio">Início:</label>
                                    <input type="time" id="horario_inicio" name="horario_inicio" required />
                                </div>
                                <div>
                                    <label htmlFor="horario_fim">Fim:</label>
                                    <input type="time" id="horario_fim" name="horario_fim" required />
                                </div>

                            </div>

                            <div className={styles.cantainerSubmit}>
                                <input type="submit" value="Adicionar Funcionário" />
                            </div>

                        </form>
                    </div>
                </section>
            )}
        </>)
}
export default AddEmpregados