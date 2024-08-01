import { faCalendarAlt } from "@fortawesome/free-solid-svg-icons/faCalendarAlt";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { useState } from "react"
import Calendar from "react-calendar";



function Data() {
    const datesPart = (date) => {
        return [
            date.toLocaleDateString('pt-BR', { weekday: 'long' }),// Obtém o nome do dia da semana em português
            date.getDate(),
            date.getMonth() + 1, // getMonth() retorna 0-11, então adicionamos 1
            date.getFullYear()
            
        ]
    }
    
  //  let day = now.getDate();
    //let month = now.getMonth() + 1; // getMonth() retorna 0-11, então adicionamos 1
    //let year = now.getFullYear();
    //let weekDay = now.toLocaleDateString('pt-BR', { weekday: 'long' }); // Obtém o nome do dia da semana em português

    const [showCalendar, setShowCalendar] = useState(false);
    const [selectDate, setSelectDate] = useState(new Date())
    const alternarCalendario = () => {
        setShowCalendar(!showCalendar)
    };
    const changeDate = (date) => {
        setSelectDate(date);
        setShowCalendar(false)
    }
    let now = datesPart(selectDate);

    return (
        <div className="data">
            <p>{now[0]}</p>
            <p>{now[1]}</p>
            <p>{now[2]}</p>
            <p>{now[3]}</p>
            <div className="icon-date">
                <FontAwesomeIcon icon={faCalendarAlt}
                    onClick={alternarCalendario}
                />
                {showCalendar && (<div>
                    <Calendar onChange={changeDate}
                    />
                </div>)}

            </div>

        </div>
    )
}
export default Data