import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import styles from './LiMenu.module.css'

function LiMenu({func, angle, icon, title }) {
    return (
        < div className={styles.list}>
                <FontAwesomeIcon className={styles.icon} icon={icon}/>
            <ol>
                <li>{title}</li>
            </ol>
                <FontAwesomeIcon onClick={func} className={styles.angle} icon={angle}/>
        </div>

    )
}
export default LiMenu