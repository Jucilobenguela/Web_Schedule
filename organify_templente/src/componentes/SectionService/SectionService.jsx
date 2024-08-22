import { useEffect, useState } from "react"
import style from './SectionService.module.css'

function SectionService({status}){
    const[isVisivel, setIsVisivel] = useState(status);
    useEffect(()=>{
        setIsVisivel(status);
    }, [status])
    return(
        <>
        {
            isVisivel && (
                <section>
                    <div className={style.container}>
                        <h3>Service</h3>

                    </div>
                </section>
            )
        }
        </>
    )
}
export default SectionService