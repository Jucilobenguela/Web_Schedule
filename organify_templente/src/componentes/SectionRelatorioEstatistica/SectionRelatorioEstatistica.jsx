import { useEffect, useState } from "react";
import style from './SectionRelatorioEstatistica.module.css'

function SectionRelatorioEstatistica({ status }) {
    const [isVisivel, setIsVisivel] = useState(status);
    useEffect(()=>{
        setIsVisivel(status)
    }, [status])
    return (
        <>{
            isVisivel && (
                <section>
                <div className={style.container}>
                    <h3>Relatório e Estatística</h3>
                </div>
                </section>
        )
        }
        </>

    )
}
export default SectionRelatorioEstatistica