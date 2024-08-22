import { faAngleRight, faBriefcase, faCalendar, faChartLine, faPeopleGroup, faTimes } from '@fortawesome/free-solid-svg-icons'
import LiMenu from '../LiMenu/LiMenu'
import styles from './NavBar.module.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
function NavBar({funcEmpregado, funcAgenda, funcService, funcRelatiroEstatistica}) {
  
    return (
        <nav className={styles.navbar}>
            <div className={styles.containerClose}>
                <FontAwesomeIcon className={styles.icon} icon={faTimes} />
            </div>
            <div className={styles.containerSearch}>
                <input id={styles.inputSearch} type="text" placeholder='Search' />
                <label htmlFor={styles.inputSearch}></label>

            </div>
            <div className={styles.containerTitleList}>
                <h3>
                    Gerenciamento
                </h3>

            </div>
            <div className={styles.containerList}>
                <LiMenu func={funcEmpregado} icon={faPeopleGroup} title={"Funcionários"} angle={faAngleRight} />
                <LiMenu func={funcAgenda} icon={faCalendar} title={"Agenda"} angle={faAngleRight} />
                <LiMenu func={funcService} icon={faBriefcase} title={"Serviços"} angle={faAngleRight} />
                <LiMenu func={funcRelatiroEstatistica} icon={faChartLine} title={"Relatórios e Estatísticas"} angle={faAngleRight} />

            </div>

        </nav>

    )
}
export default NavBar