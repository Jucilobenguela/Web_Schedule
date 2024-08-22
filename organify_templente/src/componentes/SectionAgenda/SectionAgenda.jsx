import { useEffect, useState } from "react"
import style from './SectionAgenda.module.css'

function SectionAgenda({ status }) {
    const [isVisivel, setIsVisivel] = useState(status);
    useEffect(()=>{
        setIsVisivel(status)
    }, [status])
    return (
        <>{
            isVisivel && (
                <section>
                <div className={style.container}>
                    <h3>Agenda</h3>
                    <form action="" method="Post">
                        <div>
                            <input type="datetime" name="" id="" />
                        </div>
                    </form>
                </div>
                </section>
        )
        }
        </>

    )
}
export default SectionAgenda